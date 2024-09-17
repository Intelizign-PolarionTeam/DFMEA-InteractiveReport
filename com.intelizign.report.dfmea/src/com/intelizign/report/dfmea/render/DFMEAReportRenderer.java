package com.intelizign.report.dfmea.render;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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
	public String render() throws Exception{
		if (warningMessage != null) {
			return context.renderWarning(warningMessage);
		}
	InputStream stream = getClass().getResourceAsStream("/webapp/render.vm");
	System.out.print("stream is" + stream+"\n");
	if (stream != null) {

		File tempFile = File.createTempFile("CreateProject", ".html");
		Files.copy(stream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		Document doc = Jsoup.parse(tempFile, "UTF-8");
		String modifiedHtml = doc.outerHtml();
		HtmlFragmentBuilder builder = context.createHtmlFragmentBuilder();
		builder.html(modifiedHtml);

		return builder.toString();
	} else {
		return context.renderWarning("HTML file not found.");
	}
}


}
