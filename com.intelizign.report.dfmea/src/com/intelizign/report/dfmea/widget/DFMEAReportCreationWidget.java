package com.intelizign.report.dfmea.widget;

import com.intelizign.report.dfmea.render.DFMEAReportRenderer;
import com.polarion.alm.shared.api.SharedContext;
import com.polarion.alm.shared.api.model.rp.parameter.ParameterFactory;
import com.polarion.alm.shared.api.model.rp.parameter.RichPageParameter;
import com.polarion.alm.shared.api.model.rp.widget.RichPageWidget;
import com.polarion.alm.shared.api.model.rp.widget.RichPageWidgetContext;
import com.polarion.alm.shared.api.model.rp.widget.RichPageWidgetRenderingContext;
import com.polarion.alm.shared.api.utils.collections.ReadOnlyStrictMap;


public class DFMEAReportCreationWidget extends RichPageWidget {
	
	private static final String DFMEA_WIDGET_ICON = "CreateProject.png";
	private static final String DFMEA_RECORDS_WIDGET_INFO = "This Widget helps to Develop DFMEA Interactive Report";
	private static final String DFMEA_WIDGET_LABEL = "DFMEA Interactive Report";

	//Providing DFMEA Widget Info
	@Override
	public String getDetailsHtml(RichPageWidgetContext arg0) {
		return DFMEA_RECORDS_WIDGET_INFO;
	}

	//Providing DFMEA Widget Icon
	@Override
	public String getIcon(RichPageWidgetContext context) {
		return context.resourceUrl(DFMEA_WIDGET_ICON);
	}

	//Providing DFMEA Widget Label
	@Override
	public String getLabel(SharedContext sharedContext) {
		return DFMEA_WIDGET_LABEL;
	}

	@Override
	public ReadOnlyStrictMap<String, RichPageParameter> getParametersDefinition(ParameterFactory arg0) {
		return null;
	}

	@Override
	public String renderHtml(RichPageWidgetRenderingContext widgetContext) {
		return new DFMEAReportRenderer(widgetContext).render();
	}

}
