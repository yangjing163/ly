package com.ly.a.web.tools;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;

import com.ly.a.service.tools.SpringSecurityUtil;
import com.ly.user.service.UserQxMenuService;

/**
 * 描述：Tiles Sidebar的数据填充
 * 
 * @author 刘咏
 * @version 1.1
 * 
 * @日期：2014-10-27
 */
public class SidebarViewPreparer implements ViewPreparer {

	@Autowired
	private UserQxMenuService qxMenuService;

	public void execute(Request tilesRequest, AttributeContext attributeContext)
			throws PreparerException {

		attributeContext.putAttribute(
				"menus",
				new Attribute(qxMenuService.getForMenu(SpringSecurityUtil
						.getUser().getUsername())));
	}
}
