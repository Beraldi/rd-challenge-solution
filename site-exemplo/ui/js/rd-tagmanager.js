/**
 * Minified by jsDelivr using UglifyJS v3.0.24.
 * Original file: /npm/js-cookie@2.2.0/src/js.cookie.js
 *
 * Do NOT use SRI with dynamically generated files! More information: https://www.jsdelivr.com/using-sri-with-dynamic-files
 */
!function(e){var n=!1;if("function"==typeof define&&define.amd&&(define(e),n=!0),"object"==typeof exports&&(module.exports=e(),n=!0),!n){var o=window.Cookies,t=window.Cookies=e();t.noConflict=function(){return window.Cookies=o,t}}}(function(){function e(){for(var e=0,n={};e<arguments.length;e++){var o=arguments[e];for(var t in o)n[t]=o[t]}return n}function n(o){function t(n,r,i){var c;if("undefined"!=typeof document){if(arguments.length>1){if("number"==typeof(i=e({path:"/"},t.defaults,i)).expires){var a=new Date;a.setMilliseconds(a.getMilliseconds()+864e5*i.expires),i.expires=a}i.expires=i.expires?i.expires.toUTCString():"";try{c=JSON.stringify(r),/^[\{\[]/.test(c)&&(r=c)}catch(e){}r=o.write?o.write(r,n):encodeURIComponent(String(r)).replace(/%(23|24|26|2B|3A|3C|3E|3D|2F|3F|40|5B|5D|5E|60|7B|7D|7C)/g,decodeURIComponent),n=(n=(n=encodeURIComponent(String(n))).replace(/%(23|24|26|2B|5E|60|7C)/g,decodeURIComponent)).replace(/[\(\)]/g,escape);var s="";for(var f in i)i[f]&&(s+="; "+f,!0!==i[f]&&(s+="="+i[f]));return document.cookie=n+"="+r+s}n||(c={});for(var p=document.cookie?document.cookie.split("; "):[],d=/(%[0-9A-Z]{2})+/g,u=0;u<p.length;u++){var l=p[u].split("="),C=l.slice(1).join("=");this.json||'"'!==C.charAt(0)||(C=C.slice(1,-1));try{var g=l[0].replace(d,decodeURIComponent);if(C=o.read?o.read(C,g):o(C,g)||C.replace(d,decodeURIComponent),this.json)try{C=JSON.parse(C)}catch(e){}if(n===g){c=C;break}n||(c[g]=C)}catch(e){}}return c}}return t.set=t,t.get=function(e){return t.call(t,e)},t.getJSON=function(){return t.apply({json:!0},[].slice.call(arguments))},t.defaults={},t.remove=function(n,o){t(n,"",e(o,{expires:-1}))},t.withConverter=n,t}return n(function(){})});
//# sourceMappingURL=/sm/f6937b1819ab68f00d8b787ead6c16bfb67977e0c408909621a3b2ff82dbad4a.map

!(function() {
  var DA_CLIENT_ID = "[%CID%]";
  var DA_CLIENT_NAME = "[%CNAME%]";
  var DA_CLIENT_PIPE = "[%CPIPE%]";
  var DA_SCRIPT_ID = "[%SID%]";
  var DA_SCRIPT_NAME = "[%SNAME%]";
  var DA_SOURCE = "[%SOURCE%]";
  var DA_Endpoint = "http://127.0.0.1:3002";
  // var DA_Endpoint = "https://rd-challenge-solution-app.herokuapp.com";
  var DA_Referer = window.location.href || document.referrer;
  var DA_uuidRegEx = "[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}";

  var f = function() {

    var _this = this;

    this.setPixelImg = function(_src) {
      var img = document.createElement("img");
      img.src = _src
      img.style.width = "0px";
      img.style.height = "0px";
      img.style.display = "none";
      document.body.appendChild(img);
    }

    this.sync = function(_cid, _url, _email) {
      console.log("_cid, _url, _email", _cid, _url, _email);
      var _src = DA_Endpoint + "/cookie/track/?cid=" + _cid + "&url=" + escape(_url);
      _this.setPixelImg(_src);
    }

    this.setFingerprint = function(_value) {
      _this.sync("fp", _value);
    }

  }

  if(Cookies.get('br.com.resultadosdigitais.challenge') == undefined){
    var dt = new Date().getTime();
    DA_CLIENT_ID = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = (dt + Math.random()*16)%16 | 0;
        dt = Math.floor(dt/16);
        return (c=='x' ? r :(r&0x3|0x8)).toString(16);
    });

    Cookies.set('br.com.resultadosdigitais.challenge', DA_CLIENT_ID);
  }else{
    DA_CLIENT_ID = Cookies.get('br.com.resultadosdigitais.challenge');
  }

  var track = new f();

  window.onhashchange = function(event){
    track.sync(DA_CLIENT_ID, window.location.hash ? window.location.hash : DA_Referer);
  };

  track.sync(DA_CLIENT_ID, window.location.hash ? window.location.hash : DA_Referer);

  //cookieSync
  // f.setPixelImg("https://ib.adnxs.com/getuid?" + DA_Endpoint + "/pixel/sync?k=adnxs_uid&v=$UID&cId=" + DA_CLIENT_ID);
  // f.setPixelImg("https://pixel.mathtag.com/sync/img?redir=" + escape(DA_Endpoint + "/pixel/sync?k=mm_uuid&v=[MM_UUID]&cId=" + DA_CLIENT_ID));
  // if (typeof(DA_DBM_USER_ID) != "undefined") {
  //   f.sync("dbm_id", DA_DBM_USER_ID);
  // }

  // [ % CUSTOM_CODE % ]
})();
