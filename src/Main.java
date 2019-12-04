import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Main {
    private static String[] paths = {"D:\\Softwares\\Sort\\SourceCode\\csvs\\rand1.csv",
            "D:\\Softwares\\Sort\\SourceCode\\csvs\\rand2.csv"
//            , "D:\\testing\\Downloads\\rand2.csv"
//            , "D:\\testing\\Downloads\\500000_Sales_Records.csv"
    };
    private static int max = 0;

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        ArrayList<Integer> bubbleSortData = new ArrayList<>();
        ArrayList<Integer> insertionSortData = new ArrayList<>();
        ArrayList<Integer> selectionSortData = new ArrayList<>();
        ArrayList<Integer> mergeSortData = new ArrayList<>();
        ArrayList<Integer> quickSortData = new ArrayList<>();

        for (int tmp = 0; tmp < paths.length; tmp++) {
            String line = "";
            int x = 0;
            int target = 10000;
            try {
                data.clear();
                Runtime runtime = Runtime.getRuntime();
                BufferedReader br = new BufferedReader(new FileReader(paths[tmp]));
                getCSVLineCount(paths[tmp]);
                br.readLine(); //remove first line
                XYSeries bubbleSort = new XYSeries("Bubble Sort");
                XYSeries insertionSort = new XYSeries("Insertion Sort");
                XYSeries selectionSort = new XYSeries("Selection Sort");
                XYSeries mergeSort = new XYSeries("Merge Sort");
                XYSeries quickSort = new XYSeries("Quick Sort");

                XYSeries bubbleSortSpace = new XYSeries("Bubble Sort");
                XYSeries insertionSortSpace = new XYSeries("Insertion Sort");
                XYSeries selectionSortSpace = new XYSeries("Selection Sort");
                XYSeries mergeSortSpace = new XYSeries("Merge Sort");
                XYSeries quickSortSpace = new XYSeries("Quick Sort");

                bubbleSort.add((double) 0, (double) 0);
                insertionSort.add((double) 0, (double) 0);
                selectionSort.add((double) 0, (double) 0);
                mergeSort.add((double) 0, (double) 0);
                quickSort.add((double) 0, (double) 0);

                bubbleSortSpace.add((double) 0, (double) 0);
                insertionSortSpace.add((double) 0, (double) 0);
                selectionSortSpace.add((double) 0, (double) 0);
                mergeSortSpace.add((double) 0, (double) 0);
                quickSortSpace.add((double) 0, (double) 0);

                while (target < max) {
                    long timeElapsedBubbleSort = 0;
                    long timeElapsedInsertionSort = 0;
                    long timeElapsedSelectionSort = 0;
                    long timeElapsedMergeSort = 0;
                    long timeElapsedQuickSort = 0;

                    long spaceComplexityBubbleSort = 0;
                    long spaceComplexityInsertionSort = 0;
                    long spaceComplexitySelectionSort = 0;
                    long spaceComplexityMergeSort = 0;
                    long spaceComplexityQuickSort = 0;

                    for (int i = 0; i < 5; i++) {
                        while (x <= target) {
                            line = br.readLine();
                            if (line != null) {
                                String[] row = line.split(",");
                                data.add(Integer.parseInt(row[0].replaceAll("[^a-zA-Z0-9]","")));
                            }
                            x++;
                        }
                        bubbleSortData.clear();
                        insertionSortData.clear();
                        selectionSortData.clear();
                        mergeSortData.clear();
                        quickSortData.clear();

                        bubbleSortData.addAll(data);
                        insertionSortData.addAll(data);
                        selectionSortData.addAll(data);
                        mergeSortData.addAll(data);
                        quickSortData.addAll(data);

                        //Bubble Sort
                        runtime.gc();
                        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
                        Instant start = Instant.now();
                        BubbleSort.bubbleSort(bubbleSortData);
                        Instant finish = Instant.now();
                        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
                        timeElapsedBubbleSort += Duration.between(start, finish).toMillis();
                        spaceComplexityBubbleSort = usedMemoryAfter - usedMemoryBefore;

                        //Insertion Sort
                        runtime.gc();
                        usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
                        start = Instant.now();
                        InsertionSort.insertionSort(insertionSortData);
                        finish = Instant.now();
                        usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
                        timeElapsedInsertionSort += Duration.between(start, finish).toMillis();
                        spaceComplexityInsertionSort = usedMemoryAfter - usedMemoryBefore;

                        //Selection Sort
                        runtime.gc();
                        usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
                        start = Instant.now();
                        SelectionSort.selectionSort(selectionSortData);
                        finish = Instant.now();
                        usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
                        timeElapsedSelectionSort += Duration.between(start, finish).toMillis();
                        spaceComplexitySelectionSort = usedMemoryAfter - usedMemoryBefore;

                        //Merge Sort
                        runtime.gc();
                        usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
                        start = Instant.now();
                        MergeSort.mergeSort(mergeSortData);
                        finish = Instant.now();
                        usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
                        timeElapsedMergeSort += Duration.between(start, finish).toMillis();
                        spaceComplexityMergeSort = usedMemoryAfter - usedMemoryBefore;

                        //Quick Sort
                        runtime.gc();
                        usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
                        start = Instant.now();
                        QuickSort.quickSort(quickSortData);
                        finish = Instant.now();
                        usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
                        timeElapsedQuickSort += Duration.between(start, finish).toMillis();
                        spaceComplexityQuickSort = usedMemoryAfter - usedMemoryBefore;
                    }

                    System.out.println("Bubble Sort -- Target: " + target + " Execution Time: " + timeElapsedBubbleSort / 5);
                    System.out.println("Insertion Sort -- Target: " + target + " Execution Time: " + timeElapsedInsertionSort / 5);
                    System.out.println("Selection Sort -- Target: " + target + " Execution Time: " + timeElapsedSelectionSort / 5);
                    System.out.println("Merge Sort -- Target: " + target + " Execution Time: " + timeElapsedMergeSort / 5);
                    System.out.println("Quick Sort -- Target: " + target + " Execution Time: " + timeElapsedQuickSort / 5);


                    System.out.println("Bubble Sort -- Target: " + target + " Space Complexity: " + spaceComplexityBubbleSort / 5);
                    System.out.println("Insertion Sort -- Target: " + target + " Space Complexity: " + spaceComplexityInsertionSort / 5);
                    System.out.println("Selection Sort -- Target: " + target + " Space Complexity: " + spaceComplexitySelectionSort / 5);
                    System.out.println("Merge Sort -- Target: " + target + " Space Complexity: " + spaceComplexityMergeSort / 5);
                    System.out.println("Quick Sort -- Target: " + target + " Space Complexity: " + spaceComplexityQuickSort / 5);

                    bubbleSort.add(target, (double) (timeElapsedBubbleSort / 5));
                    insertionSort.add(target, (double) (timeElapsedInsertionSort / 5));
                    selectionSort.add(target, (double) (timeElapsedSelectionSort / 5));
                    mergeSort.add(target, (double) (timeElapsedMergeSort / 5));
                    quickSort.add(target, (double) (timeElapsedQuickSort / 5));

                    bubbleSortSpace.add(target, (double) (spaceComplexityBubbleSort / 5));
                    insertionSortSpace.add(target, (double) (spaceComplexityInsertionSort / 5));
                    selectionSortSpace.add(target, (double) (spaceComplexitySelectionSort / 5));
                    mergeSortSpace.add(target, (double) (spaceComplexityMergeSort / 5));
                    quickSortSpace.add(target, (double) (spaceComplexityQuickSort / 5));

                    target += 10000;
                }

                XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(bubbleSort);
                dataset.addSeries(insertionSort);
                dataset.addSeries(selectionSort);
                dataset.addSeries(mergeSort);
                dataset.addSeries(quickSort);

                JFreeChart chart = ChartFactory.createXYLineChart("Sorting Techniques Simulation",
                        "Size", "Execution Time", dataset);

                generateChart(dataset, chart, "TimeComplexityDataset" + (tmp + 1) + ".jpeg");

                XYSeriesCollection datasetSpace = new XYSeriesCollection();
                datasetSpace.addSeries(bubbleSortSpace);
                datasetSpace.addSeries(insertionSortSpace);
                datasetSpace.addSeries(selectionSortSpace);
                datasetSpace.addSeries(mergeSortSpace);
                datasetSpace.addSeries(quickSortSpace);

                JFreeChart chartSpace = ChartFactory.createXYLineChart("Sorting Techniques Simulation",
                        "Size", "Memory Used", datasetSpace);

                generateChart(datasetSpace, chartSpace, "SpaceComplexityDataset" + (tmp + 1) + ".jpeg");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void generateChart(XYSeriesCollection dataset, JFreeChart chart, String fileName) {
        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.YELLOW);
        renderer.setSeriesPaint(3, Color.BLACK);
        renderer.setSeriesPaint(4, Color.BLUE);

        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        renderer.setSeriesStroke(3, new BasicStroke(2.0f));
        renderer.setSeriesStroke(4, new BasicStroke(2.0f));

        plot.setOutlinePaint(Color.GRAY);
        plot.setOutlineStroke(new BasicStroke(1.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        int width = 940;    /* Width of the image */
        int height = 780;   /* Height of the image */

        try {
            File lineChart = new File("D:\\testing\\Desktop\\" + fileName);
            ChartUtilities.saveChartAsJPEG(lineChart, chart, width, height);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getCSVLineCount(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while (br.readLine() != null) {
                max++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
