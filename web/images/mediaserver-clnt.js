var mediaserver_height="";
var mediaserver_width="";
var mediaserver_location="";
var mediaserver_contenttype="";
var mediaserver_id="";
var mediaserver_uname="";
var mediaserver_comp="";
var mediaserver_mcat="";
var mediaserver_cat="";
var mediaserver_grp="";
var mediaserver_cmpg="";
var mediaserver_kwd="";
var mediaserver_otherparam="";
var mediaserver_nomore=0;
var mediaserver_noadv=0;
var mediaserver_newwin=0;
var mediaserver_paidonly=0;
var mediaserver_useiframe=0;
var mediaserver_parentwindow=0;


function serve_ad(mycompid)
{

	var mediaserver_ad_url = 'http://www.media4trade.com/mediaserver?';
	var mediaserver_size = mediaserver_width+'x'+mediaserver_height;
	
	var mediaserver_pageurl;
	if(mediaserver_parentwindow == 1)
	{
		mediaserver_pageurl = parent.document.location;
	}
	else
	{
		mediaserver_pageurl = document.location;
	}
	

	mediaserver_ad_url += 'action=show';
	mediaserver_ad_url += '&pageurl=' + encodeURIComponent(mediaserver_pageurl);
	mediaserver_ad_url += '&location=' + mediaserver_location;
	mediaserver_ad_url += '&kwd=' + encodeURIComponent(mediaserver_kwd);
	mediaserver_ad_url += '&size=' + mediaserver_size;
	mediaserver_ad_url += '&contenttype=' + mediaserver_contenttype;
	mediaserver_ad_url += '&id=' + mediaserver_id;
	mediaserver_ad_url += '&uname=' + mediaserver_uname;
	
	if(mycompid)
	{
		mediaserver_ad_url += '&comp=' + mycompid;
	}
	else
	{
		mediaserver_ad_url += '&comp=' + mediaserver_comp;
	}
	
	mediaserver_ad_url += '&mcat=' + mediaserver_mcat;
	mediaserver_ad_url += '&cat=' + mediaserver_cat;
	mediaserver_ad_url += '&grp=' + mediaserver_grp;
	mediaserver_ad_url += '&cmpg=' + mediaserver_cmpg;
	mediaserver_ad_url += '&otherparam=' + encodeURIComponent(mediaserver_otherparam);
	mediaserver_ad_url += '&nomore=' + mediaserver_nomore;
	mediaserver_ad_url += '&noadv=' + mediaserver_noadv;
	mediaserver_ad_url += '&newwin=' + mediaserver_newwin;
	mediaserver_ad_url += '&paidonly=' + mediaserver_paidonly;

	if(mediaserver_contenttype == 'prdbanner') {mediaserver_noadv = 1;}
	
	if(mediaserver_useiframe)
	{
		if(!mediaserver_noadv)
		{
			mediaserver_height = parseInt(mediaserver_height)+20;
		}

		mediaserver_ad_url += '&iframe=1';
		document.write('<center><ifr'+'ame id="'+mediaserver_location+'" src="' + mediaserver_ad_url + '" width="'+mediaserver_width+'" height="'+mediaserver_height+'" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" target="_top"></ifr'+'ame></center>');
	}
	else
	{
		mediaserver_ad_url += '&iframe=0';
		document.write('<center><scr'+'ipt type="text/javascript" src="' + mediaserver_ad_url + '"></scr'+'ipt></center>');
	}
}
