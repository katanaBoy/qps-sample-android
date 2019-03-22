package com.solvd.carinademoapplication.test_screens.charts;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.NameValueDataEntry;
import com.anychart.charts.Venn;
import com.solvd.carinademoapplication.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentVennDiagram extends Fragment {

    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chart, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initVennDiagram(view);
    }

    private void initVennDiagram(View view) {
        AnyChartView anyChartView = view.findViewById(R.id.chartView);
        anyChartView.setProgressBar(view.findViewById(R.id.progress_bar));

        Venn venn = AnyChart.venn();

        List<DataEntry> data = new ArrayList<>();
        data.add(new NameValueDataEntry("A", "Data Science", 100));
        data.add(new NameValueDataEntry("B", "Computer Science", 25));
        data.add(new NameValueDataEntry("C", "Math and Statistics", 25));
        data.add(new NameValueDataEntry("D", "Subject Matter Expertise", 25));
        data.add(new NameValueDataEntry("A&B", "Computer Science", 50));
        data.add(new NameValueDataEntry("A&C", "Math and Statistics", 50));
        data.add(new NameValueDataEntry("A&D", "Subject Matter Expertise", 50));
        data.add(new NameValueDataEntry("B&C", "Machine\\nLearning", 5));
        data.add(new NameValueDataEntry("C&D", "Traditional\\nResearch", 5));
        data.add(new NameValueDataEntry("D&B", "Traditional\\nSoftware", 5));
        data.add(new NameValueDataEntry("B&C&D", "Unicorn", 5));

        venn.data(data);

        venn.stroke("2 #FFFFFF");

        venn.labels().format("{%Name}");

        venn.intersections().hovered().fill("black", 0.25d);

        venn.intersections().labels().fontWeight("bold");
        venn.intersections().labels().format("{%Name}");

        venn.tooltip().titleFormat("{%Name}");

        anyChartView.setChart(venn);
    }
}
