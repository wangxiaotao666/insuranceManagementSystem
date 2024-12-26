 /* jqeury-CcUi 0.1
 * Copyright (c) 2012 Chuchur  http://www.Chuchur.com/
 * Date: 2012-6-25
 * 
 */
(function () {
    // 
    var plugin = jQuery.sub();
    // 
    plugin.fn.extend({
        tableUi: function (options) {
            var defaults = {
                thCss: 'thCss', //
                evenRowCss: 'treven', //
                oddRowCss: 'trodd',   //
                activeCss: 'tractive'  //
            }
            var options = $.extend(defaults, options);
            return this.each(function () {
                var o = options;
                var tb = $(this);
                //
                tb.find("tr:even").addClass(o.evenRowCss);
                tb.find("tr:odd").addClass(o.oddRowCss);
                tb.find("th").addClass(o.thCss);
                //
                tb.find("tr").bind("mouseover", function () {
                    $(this).addClass(o.activeCss);
                });
                tb.find("tr").bind("mouseout", function () {
                    $(this).removeClass(o.activeCss);
                });
            })
        },
        tabs: function (options) { 
		var defaults = {
                MouseMode: 'mouseover' //
            }
            var options = $.extend(defaults, options);
            return this.each(function () {
				var o = options;
				var tabs = $(this);
				tabs.find('.list').not(':first').hide();
				var _nav = tabs.find('.nav a');
				_nav.eq(0).addClass('myon');
				var _panle = tabs.find('.list');
				$(_nav,tabs).bind(o.MouseMode,function(){
					var _index = $(_nav,tabs).index(this);
					_panle.hide().eq(_index).show();
					$(_nav).removeClass('myon').eq(_index).addClass('myon');
					}) 
				})
        }
    });
    // 
    jQuery.fn.Chuchur = function () {
        this.addClass("plugin");
        //
        return plugin(this);
    };
})();// JavaScript Document
$(function(){
		$('.tb').Chuchur().tableUi();
	})