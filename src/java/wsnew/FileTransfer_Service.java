/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsnew;

import db.DBLayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Ravi
 */
public class FileTransfer_Service {

    DBLayer dbl = new DBLayer();

    public int getMinMaxID() {
        int minMaxID = dbl.getMinMaxID();
        return minMaxID;
    }

    public String checkHash(String hash) {
        String checkHash = dbl.checkHash(hash);
        return checkHash;
    }

    public boolean uploadtodb(String filename, String uid, String hash, long timetaken, String filesize, String savesize, int share, int link) {
        boolean result = dbl.insertFilelist(uid, filename, share, link, filename, hash, share, link);
        return result;
    }

    public List<Object> checkChunkHash(String hash1) {
        ArrayList checkChunkHash = dbl.checkChunkHash(hash1);
        return checkChunkHash;
    }

    public String checkShare(String fid) {
        String checkShare = dbl.checkShare(fid);
        return checkShare;
    }

    public boolean beforeupload(String filename, String uid, String hash, int share, int link, String foldername) {

        Vector v1 = new Vector();
        v1.add(filename);
        Vector v2 = new Vector();
        v2.add(hash);
        Vector v3 = new Vector();
        v3.add(link);
        Vector v4 = new Vector();
        v4.add(uid);

        boolean insertintoFileDetails = dbl.insertintoFileDetails(v1, v2, v3, v4);
        return insertintoFileDetails;
    }

    public boolean insertfilelistentry(String uid, String filename, int min, int max, String foldername, String hash, long timetaken, String filesize, String savesize, int share, int link) {
        boolean insertFilelist = dbl.insertFilelist(uid, filename, min, max, foldername, hash, share, link);

        return insertFilelist;
    }

    public boolean upload(String filename, byte[] filebytes, String uid, String hash, int share, int link, String foldername) {
        Vector v1 = new Vector();
        v1.add(filename);
        Vector v2 = new Vector();
        v2.add(hash);
        Vector v3 = new Vector();
        v3.add(link);
        Vector v4 = new Vector();
        v4.add(uid);

        boolean insertintoFileDetails = dbl.insertintoFileDetails(v1, v2, v3, v4);
        return insertintoFileDetails;

    }

    public String chkLogin(String username, String password) {
        String validUser = dbl.isValidUser(username, password);
        return validUser;
    }

    public List<Object> getAllFiles(int uid) {
        ArrayList allFiles = dbl.getAllFiles(uid);
        return allFiles;
    }

    public List<Object> downloadFile(String fid) {

        ArrayList downloadFileDetails = dbl.getDownloadFileDetails(fid);
        return downloadFileDetails;
    }

    public byte[] getChunk(String foldername, String filename) {
        byte[] ba = new byte[50];
        return ba;
    }

    public boolean createNewAccount(String fname, String lname, String dob, String mobno, String gender, String email, String pass) {
        boolean createNewAccount = dbl.createNewAccount(fname, lname, dob, mobno, gender, email, pass);
        return createNewAccount;
    }

    public int getUID(String email, String pass) {
        int uid = dbl.getUID(email, pass);
        return uid;
    }

    public void registerKey(int uid, String fname, String lname, String email, int groupid) {
        dbl.registerKey(uid, fname, lname, email, groupid);

    }

    public List<Object> groupDetails() {
        List groupDetails = dbl.groupDetails();

        return groupDetails;
    }

    public void deleteFile(
            String fid) {
        dbl.deleteFile(fid);
    }

    public String sendPasswordOnMail(String fname, String lname, String email) {
        String sendPasswordOnMail11 = dbl.sendPasswordOnMail(fname, lname, email);
        
        if (sendPasswordOnMail11.equals(null)) {
            return "";
        }
        return sendPasswordOnMail11;
    }

    public List<Object> getDeletedFiles(
            int uid) {
        ArrayList deletedFiles = dbl.getDeletedFiles(uid);
        return deletedFiles;
    }

    public void undoFile(
            String fid) {
        dbl.undoFile(fid);

    }

    public Boolean isGroupValid(String gname, String emailid) {
        Boolean groupValid = dbl.isGroupValid(gname, emailid);
        return groupValid;
    }

    public void createGroup(String gname, String organization, String emailid) {

        String skey = skeygenerator();
        dbl.createGroup(gname, organization, emailid, skey);

    }

    private String skeygenerator() {
        String skey = "zaqwsxcderfvbgtyhnmjuiklopZAQWSXCDERFVBGTYHNMJUIKLOP0123456789";
        String sk = "";
        int length = skey.length();
//         System.out.println("Length "+length);
        for (int i = 0; i < 16; i++) {
            Random rd = new Random();
            int nextInt = rd.nextInt(length - 1);
//                System.out.println(nextInt);
            sk = sk + skey.charAt(nextInt);

        }
        return sk;
    }

    public List<Object> getGrouplist() {

        List l = new ArrayList();
        return l;
    }

    public String getKey(String uid, String uname, String emailid) {
        int n = Integer.parseInt(uid);
        String key = dbl.getKey(n, uname, emailid);
        return key;
    }
}
