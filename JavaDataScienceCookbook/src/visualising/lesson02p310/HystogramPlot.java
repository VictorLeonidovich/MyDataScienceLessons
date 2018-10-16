package visualising.lesson02p310;

import java.util.Random;

import de.erichseifert.gral.data.DataSource;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.data.EnumeratedData;
import de.erichseifert.gral.data.statistics.Histogram1D;
import de.erichseifert.gral.data.statistics.Statistics;
import de.erichseifert.gral.examples.ExamplePanel;
import de.erichseifert.gral.plots.BarPlot;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.util.Insets2D;
import de.erichseifert.gral.util.MathUtils;
import de.erichseifert.gral.util.Orientation;

public class HystogramPlot extends ExamplePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int SAMPLE_COUNT = 1000;

	public HystogramPlot() {
		Random random = new Random();
		DataTable data = new DataTable(Double.class);
		for (int i = 0; i < SAMPLE_COUNT; i++) {
			data.add(random.nextGaussian());
		}
		Histogram1D histogram = new Histogram1D(data, Orientation.VERTICAL,
				new Number[] { -4.0, -3.2, -2.4, -1.6, -0.8, 0.0, 0.8, 1.6, 2.4, 3.2, 4.0 });
		DataSource histogram2d = new EnumeratedData(histogram, (-4.0 + -3.2) / 2.0, 0.8);
		BarPlot plot = new BarPlot(histogram2d);
		plot.setInsets(new Insets2D.Double(20.0, 65.0, 50.0, 40.0));
		plot.getTitle().setText(String.format("Distribution of %d random samples", data.getRowCount()));
		plot.setBarWidth(0.78);
		plot.getAxisRenderer(BarPlot.AXIS_X).setTickAlignment(0.0);
		plot.getAxisRenderer(BarPlot.AXIS_X).setTickSpacing(0.8);
		plot.getAxisRenderer(BarPlot.AXIS_X).setMinorTicksVisible(false);
		plot.getAxis(BarPlot.AXIS_Y).setRange(0.0,
				MathUtils.ceil(histogram.getStatistics().get(Statistics.MAX) * 1.1, 25.0));
		plot.getAxisRenderer(BarPlot.AXIS_Y).setTickAlignment(0.0);
		plot.getAxisRenderer(BarPlot.AXIS_Y).setMinorTicksVisible(false);
		plot.getAxisRenderer(BarPlot.AXIS_Y).setIntersection(-4.4);
		plot.getPointRenderer(histogram2d).setColor(GraphicsUtils.deriveWithAlpha(COLOR1, 128));
		plot.getPointRenderer(histogram2d).setValueVisible(true);
		InteractivePanel panel = new InteractivePanel(plot);
		panel.setPannable(false);
		panel.setZoomable(false);
		add(panel);
	}

	public static void main(String[] args) {
		new HystogramPlot().showInFrame();
	}

	@Override
	public String getDescription() {
		return "Histogram plot";
	}

	@Override
	public String getTitle() {
		return String.format("Histogram of %d samples", SAMPLE_COUNT);
	}

}
