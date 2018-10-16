package visualising.lesson06p332;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.examples.ExamplePanel;
import de.erichseifert.gral.plots.PiePlot;
import de.erichseifert.gral.plots.PiePlot.PieSliceRenderer;
import de.erichseifert.gral.plots.colors.LinearGradient;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.Insets2D;

public class SimplePiePlot extends ExamplePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int SAMPLE_COUNT = 10;
	private static final Random random = new Random();

	public SimplePiePlot() {
		DataTable data = new DataTable(Integer.class);
		for (int i = 0; i < SAMPLE_COUNT; i++) {
			int val = random.nextInt(8) + 2;
			data.add((random.nextDouble() <= 0.15) ? -val : val);
		}
		PiePlot plot = new PiePlot(data);
		plot.getTitle().setText(getDescription());
		plot.setRadius(0.9);
		plot.setLegendVisible(true);
		plot.setInsets(new Insets2D.Double(20.0, 40.0, 40.0, 40.0));
		PieSliceRenderer pointRenderer = (PieSliceRenderer) plot.getPointRenderer(data);
		pointRenderer.setInnerRadius(0.4);
		pointRenderer.setGap(0.2);
		LinearGradient colors = new LinearGradient(COLOR1, COLOR2);
		pointRenderer.setColor(colors);
		pointRenderer.setValueVisible(true);
		pointRenderer.setValueColor(Color.WHITE);
		pointRenderer.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
		add(new InteractivePanel(plot), BorderLayout.CENTER);
	}

	@Override
	public String getDescription() {
		return String.format("Donut plot of %d random data values", SAMPLE_COUNT);
	}

	@Override
	public String getTitle() {
		return "Donut plot";
	}

	public static void main(String[] args) {
		new SimplePiePlot().showInFrame();
	}

}
