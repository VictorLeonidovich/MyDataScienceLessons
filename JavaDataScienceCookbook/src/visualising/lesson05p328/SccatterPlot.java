package visualising.lesson05p328;

import java.awt.BorderLayout;
import java.util.Random;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.examples.ExamplePanel;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.Insets2D;

public class SccatterPlot extends ExamplePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int SAMPLE_COUNT = 100000;
	private static final Random random = new Random();

	public SccatterPlot() {
		DataTable data = new DataTable(Double.class, Double.class);
		for (int i = 0; i <= SAMPLE_COUNT; i++) {
			data.add(random.nextGaussian() * 2.0, random.nextGaussian() * 2.0);
		}
		XYPlot plot = new XYPlot(data);
		plot.setInsets(new Insets2D.Double(20.0, 40.0, 40.0, 40.0));
		plot.getTitle().setText(getDescription());
		plot.getPointRenderer(data).setColor(COLOR1);
		add(new InteractivePanel(plot), BorderLayout.CENTER);
	}

	@Override
	public String getDescription() {
		return String.format("Scatter plot with %d data points", SAMPLE_COUNT);
	}

	@Override
	public String getTitle() {
		return "Scatter plot";
	}

	public static void main(String[] args) {
		new SccatterPlot().showInFrame();
	}

}
