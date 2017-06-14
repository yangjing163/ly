package com.ly.a.web.tools;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

/**
 * 描述：Tiles页脚，页头的数据填充
 * 
 * @author 刘咏
 * @version 1.1
 * 
 * @日期：2014-10-27
 */
public class FooterViewPreparer implements ViewPreparer {

	public void execute(Request tilesRequest, AttributeContext attributeContext)
			throws PreparerException {

		attributeContext.putAttribute("copyright", new Attribute(
				"© 2016-2020 重庆市渝北区业如小额贷款有限公司 版权所有"));
	}
}
