package com.intelizign.report.dfmea.render;
import org.jetbrains.annotations.NotNull;
import com.polarion.alm.shared.api.model.rp.widget.RichPageWidgetRenderingContext;
import com.polarion.alm.shared.api.utils.html.HtmlFragmentBuilder;


public class DFMEAReportRenderer {

	@NotNull
	private final RichPageWidgetRenderingContext context;
	private String warningMessage;
	
	public DFMEAReportRenderer(@NotNull final RichPageWidgetRenderingContext context) {
		this.context = context;
	}
	
	@SuppressWarnings("unused")
	private void reportWarning(@NotNull String message) {
		warningMessage = message;
	}

	@NotNull
	public String render() {
	    HtmlFragmentBuilder builder = context.createHtmlFragmentBuilder();

	    if (warningMessage != null) {
	        return context.renderWarning(warningMessage);
	    }

	  	 
	    /*String pluginId = "com.polarion.createproject";
	    Bundle bun = Platform.getBundle(pluginId);	   
	    String relativeFilePath = "src/com/polarion/createproject/CreateProject.html";
	    Pattern pattern = Pattern.compile("[A-Z]:.*$");
	    Matcher matcher = pattern.matcher(bun.getLocation());
	    String pathLocation = null;
	    if (matcher.find()) {
	        pathLocation = matcher.group(0);
	    }
	    String actualLocation = pathLocation + relativeFilePath;	   
	    try {	       
	    
	        ITrackerService trackerService = (ITrackerService) PlatformContext.getPlatform()
	                .lookupService(ITrackerService.class);	       
	        IProjectGroup rootGroup = (IProjectGroup) trackerService.getProjectsService().getRootProjectGroup()
	                .getContainedGroups().get(0);
	        rootGroupList = listProjectGroup(rootGroup);	 
	       
	        Document doc = Jsoup.parse(new File(actualLocation), "UTF-8");	 
	        String modifiedHtml = doc.outerHtml();
	        builder.html(modifiedHtml);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return builder.toString();*/
	    return builder.toString();
	}

}
