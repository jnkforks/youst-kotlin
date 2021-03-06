package mx.yellowme.youst.playground.ui.chart.utils

import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.BubbleDataSet
import com.github.mikephil.charting.data.BubbleEntry
import com.github.mikephil.charting.data.LineDataSet
import mx.yellowme.youst.playground.domain.ChartEntry
import mx.yellowme.youst.playground.domain.ChartType

/**
 * @author adrianleyvasanchez
 * @since 08,October,2019
 */
object DataSetConverter {
    fun <BarLineScatterCandleBubbleDataSet> convertDataSetList(
        listOfEntries: ArrayList<ChartEntry>,
        type: ChartType
    ): BarLineScatterCandleBubbleDataSet {
        when (type) {
            ChartType.BAR -> {
                val barEntries = ArrayList<BarEntry>()
                for (entry in listOfEntries) {
                    barEntries.add(BarEntry(entry.x, entry.y))
                }
                return BarDataSet(barEntries, "") as BarLineScatterCandleBubbleDataSet
            }
            ChartType.LINE -> {
                return LineDataSet(listOfEntries.toList(), "") as BarLineScatterCandleBubbleDataSet
            }
            ChartType.BUBBLE -> {
                val bubbleEntries = ArrayList<BubbleEntry>()
                for (entry in listOfEntries) {
                    bubbleEntries.add(BubbleEntry(entry.x, entry.y, entry.z ?: 0f))
                }
                return BubbleDataSet(bubbleEntries, "") as BarLineScatterCandleBubbleDataSet
            }
        }
    }
}
