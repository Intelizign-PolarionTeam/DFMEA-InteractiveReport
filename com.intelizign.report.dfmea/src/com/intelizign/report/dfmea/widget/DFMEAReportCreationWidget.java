package com.intelizign.report.dfmea.widget;

import org.jetbrains.annotations.NotNull;

import com.intelizign.report.dfmea.render.DFMEAReportRenderer;
import com.polarion.alm.shared.api.SharedContext;
import com.polarion.alm.shared.api.model.rp.parameter.ParameterFactory;
import com.polarion.alm.shared.api.model.rp.parameter.RichPageParameter;
import com.polarion.alm.shared.api.model.rp.widget.RichPageWidget;
import com.polarion.alm.shared.api.model.rp.widget.RichPageWidgetContext;
import com.polarion.alm.shared.api.model.rp.widget.RichPageWidgetRenderingContext;
import com.polarion.alm.shared.api.utils.collections.ReadOnlyStrictMap;
import com.polarion.alm.shared.api.utils.collections.StrictMap;
import com.polarion.alm.shared.api.utils.collections.StrictMapImpl;


public class DFMEAReportCreationWidget extends RichPageWidget {
	
	private static final String DFMEA_WIDGET_ICON = "DFMEAIcon.png";
	private static final String DFMEA_RECORDS_WIDGET_INFO = "This Widget helps to Develop DFMEA Interactive Report";
	private static final String DFMEA_WIDGET_LABEL = "DFMEA Interactive Report";

	//Providing DFMEA Widget Info
	@Override
	public String getDetailsHtml(RichPageWidgetContext arg0) {
		return DFMEA_RECORDS_WIDGET_INFO;
	}

	//Providing DFMEA Widget Icon
	@Override
	@NotNull
	public String getIcon(RichPageWidgetContext arg0) {
		return arg0.resourceUrl(DFMEA_WIDGET_ICON);
	}

	//Providing DFMEA Widget Label
	@Override
	public String getLabel(SharedContext sharedContext) {
		return DFMEA_WIDGET_LABEL;
	}

	@Override
	public ReadOnlyStrictMap<String, RichPageParameter> getParametersDefinition(ParameterFactory arg0) {
		StrictMap<String, RichPageParameter> parameters = new StrictMapImpl<String, RichPageParameter>();
		
		return parameters;
	}

	@Override
	public String renderHtml(RichPageWidgetRenderingContext widgetRenderingContext){
			try {
				return new DFMEAReportRenderer(widgetRenderingContext).render();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

}
