/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rahul
 */
public class DBLayer {

    Connection con = null;
    String dbname = "cloudupload";
    String dburl = "Localhost";
    String dbusername = "root";
    String dbpassword = "root";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        System.out.println("Diver loading");
//        Class.forName("com.mysql.jdbc.Driver");
//        System.out.println("Diver loadedddd");
//        con = DriverManager.getConnection("jdbc:mysql://cloudzones.org/cloudupload", "cloudupload", "cloudupload@4321");
//        System.out.println("connected");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            con = DriverManager.getConnection("jdbc:mysql://" + dburl + "/" + dbname, dbusername, dbpassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection() throws ClassNotFoundException, SQLException {
        con.close();
    }

    public boolean createNewAccount(String fName, String lName, String dob, String mobileNo, String gender, String emailId, String password) {
        try {
            boolean result = isEmailPresent(emailId);
            System.out.println("result" + result);
            if (result == false) {
                PreparedStatement ps;
                ps = getConnection().prepareStatement("insert into userregistration (firstname,lastname,dateofbirth,mobileno,gender,emailid,password)" + (" values(?,?,?,?,?,?,?)"));
                ps.setString(1, fName.trim());
                ps.setString(2, lName.trim());
                ps.setString(3, dob);
                ps.setString(4, mobileNo.trim());
                ps.setString(5, gender);
                ps.setString(6, emailId.trim());
                ps.setString(7, password.trim());
                ps.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String isValidUser(String emailId, String password) {
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select firstname,lastname,uid from userregistration where emailid=? and password=?");
            ps.setString(1, emailId);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1) + " " + rs.getString(2) + "#" + rs.getString(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "1";
        }
        return "1";
    }

    public boolean isEmailPresent(String emailId) {
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select uid from userregistration where emailid=?");
            ps.setString(1, emailId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public boolean insertFilelist(String uid, String fileName, int maxidstart, int maxidend, String foldername, String hash, int share, int link) {
        boolean execute = false;
        try {
            String sql = "insert into userfilelist (uid,filename,uploaddate,uploadtime,filestartid,fileendid,foldername,status,hash,share,link) values(?,?,CURDATE(),CURTIME(),?,?,?,?,?,?,?)";
            PreparedStatement ps;
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, uid);
            ps.setString(2, fileName);
            ps.setInt(3, maxidstart + 1);
            ps.setInt(4, maxidend);
            ps.setString(5, foldername);
            ps.setInt(6, 0);
            ps.setString(7, hash);
            ps.setInt(8, share);
            ps.setInt(9, link);
            execute = ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return execute;
    }

    public ArrayList getAllFiles(int uid) {
        ArrayList list = new ArrayList();

        try {
            String sql = "select filename,id,uploaddate,uploadtime from userfilelist where uid='" + uid + "' and status=0";
            PreparedStatement ps;
            ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dt1 = new SimpleDateFormat("hh:mm:ss");
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getInt(2));
                list.add(dt.format(rs.getDate(3)) + "");
                list.add(dt1.format(rs.getTime(4)) + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Array List elements-->" + list);
        return list;
    }

    public void deleteFile(String fid) {
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("update userfilelist set status=1 where id='" + fid + "'");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void undoFile(String fid) {
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("update userfilelist set status=0 where id='" + fid + "'");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ChunkSizeInsert(int Chunkpart) {
        try {

            PreparedStatement ps = getConnection().prepareStatement("insert into sizechunk values(" + Chunkpart + ")");
//            ps.setString(1, Chunkpart);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteChunksize() {
        try {
            PreparedStatement ps = getConnection().prepareStatement("TRUNCATE sizechunk");
            ps.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList getDeletedFiles(int uid) {
        ArrayList list = new ArrayList();

        try {
            String sql = "select filename,id,uploaddate,uploadtime from userfilelist where uid='" + uid + "' and status=1";
            PreparedStatement ps;
            ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dt1 = new SimpleDateFormat("hh:mm:ss");
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getInt(2));
                list.add(dt.format(rs.getDate(3)) + "");
                list.add(dt1.format(rs.getTime(4)) + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Array List elements-->" + list);
        return list;
    }

    public String sendPasswordOnMail(String fname, String lname, String email) {
        String result = null;
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select password from userregistration where emailid=? and firstname=? and lastname=?");
            ps.setString(1, email);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String checkHash(String hash) {
        String result = 0+"";
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select id from userfilelist where hash=? and share=1");
            ps.setString(1, hash);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1) + "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList getDownloadFileDetails(String fid) {
        ArrayList result = new ArrayList();
        String dfilename = null;
        String foldername = null;
        String filename = null;
        ResultSet rs, rs1;
        int link = 0;
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select filename,foldername,link from userfilelist where id=?");
            ps.setInt(1, Integer.parseInt(fid));
            rs = ps.executeQuery();
            if (rs.next()) {
                dfilename = rs.getString(1);
                foldername = rs.getString(2);
                link = rs.getInt(3);
            }
            closeConnection();

            while (foldername.equals("0")) {
                ps = getConnection().prepareStatement("select filename,foldername,link from userfilelist where id=?");
                ps.setInt(1, link);
                rs1 = ps.executeQuery();
                if (rs1.next()) {
                    filename = rs1.getString(1);
                    foldername = rs1.getString(2);
                    link = rs1.getInt(3);
                }
                System.out.println("foldername -" + foldername);
                System.out.println("filename -" + filename);
                System.out.println("link -" + link);
                closeConnection();
            }
            result.add(dfilename);
            result.add(foldername);
            result.add(filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean insertintoFileDetails(Vector filename, Vector hash, Vector link, Vector fileid) {
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("insert into userfiledetails (filename,uploaddate,uploadtime,hash,link,fid)" + (" values(?,CURDATE(),CURTIME(),?,?,?)"));
            for (int i = 0; i < filename.size(); i++) {

                ps.setString(1, filename.get(i).toString());
                ps.setString(2, hash.get(i).toString());
                ps.setString(3, link.get(i).toString());
                ps.setString(4, fileid.get(i).toString() + 1);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getMinMaxID() {
        int result = 0;
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select Max(id) from userfiledetails");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList checkChunkHash(String hash) {
        ArrayList result = new ArrayList();
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select id,fid from userfiledetails where hash=?");
            ps.setString(1, hash);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(rs.getInt(1) + "#" + rs.getInt(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("resultcc=>" + result);
        return result;
    }

    public int getMaxFileID() {
        int result = 0;
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select Max(id) from userfilelist");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String checkShare(String fid) {
        String result = "0";
        try {
            PreparedStatement ps;
            System.out.println("file id *****->" + fid);
            ps = getConnection().prepareStatement("select share from userfilelist where id='" + Integer.parseInt(fid) + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1) + "";
                System.out.println("share result from db->" + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList getStartidandEndid(String fid) {
        ArrayList result = new ArrayList();
        ResultSet rs, rs1;
        String link = null, filename = null;
        int sid = 0, eid = 0;

        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select filename,filestartid,fileendid,link from userfilelist where id=?");
            ps.setInt(1, Integer.parseInt(fid));
            rs = ps.executeQuery();
            if (rs.next()) {
                filename = rs.getString(1);
                sid = rs.getInt(2);
                eid = rs.getInt(3);
                link = rs.getInt(4) + "";
            }
            closeConnection();
            while (!link.equals("0")) {
                ps = getConnection().prepareStatement("select filestartid,fileendid,link from userfilelist where id=?");
                ps.setInt(1, Integer.parseInt(link));
                rs1 = ps.executeQuery();
                if (rs1.next()) {
                    sid = rs1.getInt(1);
                    eid = rs1.getInt(2);
                    link = rs1.getInt(3) + "";
                }

                closeConnection();
            }
            System.out.println("sid -" + sid);
            System.out.println("eid -" + eid);
            result.add(sid);
            result.add(eid);
            result.add(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList getFilenameandFid(int id) {
        ArrayList result = new ArrayList();
        ResultSet rs, rs1;
        String filename = null;
        int link = 0, fid = 0;
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select filename,link,fid from userfiledetails where id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                filename = rs.getString(1);
                link = rs.getInt(2);
                fid = rs.getInt(3);
            }
            closeConnection();
            while (link != 0) {
                ps = getConnection().prepareStatement("select filename,link,fid from userfiledetails where id=?");
                ps.setInt(1, link);
                rs1 = ps.executeQuery();
                if (rs1.next()) {
                    filename = rs1.getString(1);
                    link = rs1.getInt(2);
                    fid = rs1.getInt(3);
                }
                closeConnection();
            }
            System.out.println("filename -" + filename);
            System.out.println("link -" + link);
            System.out.println("fid -" + fid);
            result.add(filename);
            result.add(fid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getFoldername(int id) {
        String result = null;
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select foldername from userfilelist where id='" + id + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getUID(String email, String pass) {
        int result = 0;
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select uid from userregistration where emailid='" + email + "' and password='" + pass + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isGroupValid(String gname, String emailid) {
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select gname from grouplist where email=?");
            ps.setString(1, emailid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String st = rs.getString("gname");
                if (gname.equals(st)) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return true;
    }

    public void createGroup(String gname, String organization, String emailid, String skey) {
        try {

            PreparedStatement ps;
            ps = getConnection().prepareStatement("insert into grouplist (gname,contact,email,skey)" + (" values(?,?,?,?)"));
            ps.setString(1, gname);
            ps.setString(2, organization);
            ps.setString(3, emailid);
            ps.setString(4, skey);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public List<Object> groupDetails() {
        List l = new ArrayList();
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select gid,gname from grouplist");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("gid");
                l.add(id);
                String st = rs.getString("gname");
                l.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return l;
        }
        return l;
    }

    public void registerKey(int uid, String fname, String lname, String email, int groupid) {
        String ekey = getskey(groupid);
        try {

            PreparedStatement ps;
            ps = getConnection().prepareStatement("insert into privilegekeys (uid,ekey,fname,lname,email,groupid)" + (" values(?,?,?,?,?,?)"));
            ps.setInt(1, uid);
            ps.setString(2, ekey);
            ps.setString(3, fname);
            ps.setString(4, lname);
            ps.setString(5, email);
            ps.setInt(6, groupid);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }


    private String getskey(int gid) {
        String str = null;
        try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select skey from grouplist where gid=?");
            ps.setInt(1, gid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                str = rs.getString("skey");

            }
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
        return str;
    }
    public String getKey( int uid,String uname,String emailid) {
        String ekey="";
         try {
            PreparedStatement ps;
            ps = getConnection().prepareStatement("select fname,lname,ekey from privilegekeys where uid=? and email=?");
            ps.setInt(1, uid);
            ps.setString(2, emailid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String st = rs.getString("fname");
                String str=rs.getString("lname");
                if(uname.equals(st+" "+str)){
                    ekey=rs.getString("ekey");
//                    return(ekey);
                }
                System.out.println("username "+st +str);                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ekey;
        }
        return ekey;
    }
    
    
    public static void main(String[] args) {
        DBLayer dbl = new DBLayer();
        String key = dbl.getKey(13, "Ravi Saini", "ravisaini1611@gmail.com");
        System.out.println("Get Key  "+key);

    }
}
