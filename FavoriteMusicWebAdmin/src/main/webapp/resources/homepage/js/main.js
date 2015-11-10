

/* jquery.scrollgress vx.x | (c) n33 | n33.co @n33co | MIT */
(function(){var e="scrollwatchResume",t="length",n="removeData",r="data",i="scrollwatch-state",s="scrollwatch-suspended",o="scrollgress-suspended",u="setTimeout",a="trigger",f="scroll",l="scrollwatchSuspend",c=!0,h="scrollwatch",p=null,d="top",v="rangeMin",m="rangeMax",g="scrollgress",y=!1,b="anchor",w="unscrollwatch",E="unscrollgress",S="element",x="-id",T="scroll.",N="height",C="scrollTop",k="center",L="bottom",A=$(window),O=$(document),M=1e3;jQuery.fn[e]=function(){var l,c;if(this[t]==0)return $(this);if(this[t]>1){for(l=0;l<this[t];l++)$(this[l])[e]();return this}return c=$(this),c[r](i,-1)[n](s)[n](o),window[u](function(){A[a](f)},50),c},jQuery.fn[l]=function(){var e,n;if(this[t]==0)return $(this);if(this[t]>1){for(e=0;e<this[t];e++)$(this[e])[l]();return this}return n=$(this),n[r](s,c),window[u](function(){A[a](f)},50),n},jQuery.fn[h]=function(e){var n,a,f,l,w;if(this[t]==0)return $(this);if(this[t]>1){for(n=0;n<this[t];n++)$(this[n])[h](e);return this}return a=jQuery.extend({range:.5,rangeMin:p,rangeMax:p,anchor:d,init:p,on:p,off:p,delay:0},e),a[v]===p&&(a[v]=-1*a.range),a[m]===p&&(a[m]=a.range),f=$(this),a.init&&(w=a.init),f[r](s,y)[r](i,-1)[g](function(e){if(f[r](s)===c){a.on&&a.on(f),f[r](o,c);return}window.clearTimeout(l),l=window[u](function(){var t,n,s=parseInt(f[r](i));if(s==0||s==-1){t=a[v]===y||e>=a[v],n=a[m]===y||e<=a[m];if(t&&n){f[r](i,1),a.on&&a.on(f),w&&(w(f,c),w=p);return}}if(s==1||s==-1){t=a[v]!==y&&e<a[v],n=a[m]!==y&&e>a[m];if(t||n){f[r](i,0),a.off&&a.off(f),w&&(w(f,y),w=p);return}}},w?0:a.delay)},{anchor:a[b]},h),f},jQuery.fn[w]=function(){var e,r;if(this[t]==0)return $(this);if(this[t]>1){for(e=0;e<this[t];e++)$(this[e])[w]();return this}return r=$(this),r[n](i)[E](h),r},jQuery.fn[g]=function(e,n,i){var s,u,l,h,p;if(this[t]==0)return $(this);if(this[t]>1){for(s=0;s<this[t];s++)$(this[s])[g](e,n,i);return $(this)}return i||(i=g),u=jQuery.extend({anchor:d,direction:"both",scope:S,easing:0},n),l=$(this),l[r](i+x)||l[r](i+x,M++),h=l[r](i+x),p=T+i+"-"+h,A.off(p).on(p,function(){var t,n,i,s;if(l[r](o)===c)return;t=l.offset()[d],n=l.outerHeight(),i=O[N]();switch(u.scope){default:case S:switch(u[b]){default:case d:s=(t-A[C]())/n*-1;break;case k:s=(t-A[C]()-(A[N]()-n)/2)/n*-1;break;case L:s=(t-A[C]()-(A[N]()-n))/n*-1}break;case"window":switch(u[b]){default:case d:s=(t-A[C]())/A[N]()*-1;break;case k:s=(t-A[C]()-(A[N]()-n)/2)/A[N]()*-1;break;case L:s=(t-A[C]()-(A[N]()-n))/A[N]()*-1}}u.direction=="forwards"?s=Math.max(0,s):u.direction=="backwards"&&(s=Math.min(0,s)),s>0?s=Math.max(0,s-u.easing/100):s<0&&(s=Math.min(0,s+u.easing/100)),e(s,l)})[a](f),l},jQuery.fn[E]=function(e){var i,s,o,u;if(this[t]==0)return $(this);if(this[t]>1){for(i=0;i<this[t];i++)$(this[i])[E](e);return $(this)}return e||(e=g),s=$(this),s[r](e+x)?(o=s[r](e+x),u=T+e+"-"+o,A.off(u),s[n](e+x),s):s}})();
$('#btnsearch').click(function() {
	var search = $("#searchname").val();
	//showList(null);
	alert(search);
	if(search == ""){
		alert("검색어를 입력해 주세요");
		 $("#searchname").focus();
		 return;
	}
	
});
/*
$.ajax({
		type : 'GET',
		dataType : 'JSON',
		data :{search : search},
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		url : '/web/hellomplan'
		
	});
});
*/
$(function() {
	$("#openmodal").click(function() {
		$.blockUI({
			message : $('#modallogin')
		})
	})
})
function removeModal() {
	$.unblockUI();
}


//name="userid"  id="idcheck"
	$(document).ready(function(){
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var userInputId = getCookie("userInputId");
   // alert("userInputId  : " + userInputId);
    $("input[name='j_username']").val(userInputId); 
     
    if($("input[name='j_username']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#idcheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#idcheck").change(function(){ // 체크박스에 변화가 있다면,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
            var userInputId = $("input[name='j_username']").val();
         //   alert("userInputId  : " + userInputId);
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("userInputId");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("input[name='j_username']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#idcheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            var userInputId = $("input[name='j_username']").val();
         //   alert("userInputId  : " + userInputId);
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }
    });
});
 
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}




















/*
 * Alpha by HTML5 UP html5up.net | @n33co Free for personal and commercial use
 * under the CCA 3.0 license (html5up.net/license)
 */

(function($) {
skel.breakpoints({
		wide: '(max-width: 1680px)',
		normal: '(max-width: 1280px)',
		narrow: '(max-width: 980px)',
		narrower: '(max-width: 840px)',
		mobile: '(max-width: 736px)',
		mobilep: '(max-width: 480px)'
	});

	$(function() {

		var	$window = $(window),
			$body = $('body'),
			$header = $('#header'),
			$banner = $('#banner');

		// Fix: Placeholder polyfill.
			$('form').placeholder();

		// Prioritize "important" elements on narrower.
			skel.on('+narrower -narrower', function() {
				$.prioritize(
					'.important\\28 narrower\\29',
					skel.breakpoint('narrower').active
				);
			});

		// Dropdowns.
			$('#nav > ul').dropotron({
				alignment: 'right'
			});

		// Off-Canvas Navigation.

			// Navigation Button.
				$(
					'<div id="navButton">' +
						'<a href="#navPanel" class="toggle"></a>' +
					'</div>'
				)
					.appendTo($body);

			// Navigation Panel.
				$(
					'<div id="navPanel">' +
						'<nav>' +
							$('#nav').navList() +
						'</nav>' +
					'</div>'
				)
					.appendTo($body)
					.panel({
						delay: 500,
						hideOnClick: true,
						hideOnSwipe: true,
						resetScroll: true,
						resetForms: true,
						side: 'left',
						target: $body,
						visibleClass: 'navPanel-visible'
					});

			// Fix: Remove navPanel transitions on WP<10 (poor/buggy
			// performance).
				if (skel.vars.os == 'wp' && skel.vars.osVersion < 10)
					$('#navButton, #navPanel, #page-wrapper')
						.css('transition', 'none');

		// Header.
		// If the header is using "alt" styling and #banner is present, use
		// scrollwatch
		// to revert it back to normal styling once the user scrolls past the
		// banner.
		// Note: This is disabled on mobile devices.
			if (!skel.vars.mobile
			&&	$header.hasClass('alt')
			&&	$banner.length > 0) {

				$window.on('load', function() {

					$banner.scrollwatch({
						delay:		0,
						range:		0.5,
						anchor:		'top',
						on:			function() { $header.addClass('alt reveal'); },
						off:		function() { $header.removeClass('alt'); }
					});

				});

			}

	});
})