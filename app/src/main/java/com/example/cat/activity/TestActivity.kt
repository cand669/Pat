package com.example.cat.activity

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.drake.channel.receiveEvent
import com.drake.channel.receiveTag
import com.drake.channel.sendTag
import com.example.cat.core.BaseActivity
import com.example.cat.databinding.ActivityTestBinding
import com.example.cat.room.db.BaeDatabase
import com.example.cat.room.entity.DutyEntity
import com.example.cat.room.entity.NutEntity
import com.example.cat.room.viewmodel.FuzViewModel
import com.haibin.calendarview.Calendar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.time.LocalDate

class TestActivity : BaseActivity<ActivityTestBinding>() {
    override fun InitView() {
        val vCdv = binding.vCdv
        val fuzvm = ViewModelProvider(this).get(FuzViewModel::class.java)
        val startDate = LocalDate.of(2023, 12, 1)
        val endDate = LocalDate.of(2024, 3, 1)
        var currentDate = startDate
        var ascs = mutableListOf<NutEntity>()
        var x0 = 0
        val aa = listOf(77, 77, 77, 77, 88, 88, 99, 99)
        while (currentDate.isBefore(endDate) || currentDate.isEqual(endDate)) {
            currentDate = currentDate.plusDays(1)
            var fm = x0
            aa.shuffled().take(1).forEach {
                if (it == 99) {
                    fm = 100
                } else if (it == 88) {
                    fm = it
                }
            }
            val entity = NutEntity(localDate = currentDate, xn = fm)
            ascs.add(entity)
            x0 += 1
        }
        receiveTag("Kut") {
            var map = HashMap<String, Calendar>()
            withContext(Dispatchers.IO) {
                fuzvm.addNut(ascs)
                fuzvm.getAllNut()?.let {
                    it.forEach {
                        val ld = it.localDate
                        val year = ld.year
                        val month = ld.monthValue
                        val day = ld.dayOfMonth
                        val ap = getSchemeCalendar(year, month, day, 0xFFedc56d, it.xn.toString())
                        val ep = ap.toString()
                        map.put(ep, ap)
                    }
                }
            }
            vCdv.setSchemeDate(map)
        }
        sendTag("Kut")
    }

    private fun getSchemeCalendar(
        year: Int,
        month: Int,
        day: Int,
        color: Long,
        text: String
    ): Calendar {
        val calendar = Calendar()
        calendar.setYear(year)
        calendar.setMonth(month)
        calendar.setDay(day)
        calendar.setSchemeColor(color.toInt())
        calendar.setScheme(text)
        return calendar
    }
}