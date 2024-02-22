package com.example.cat.activity

import com.dylanc.longan.design.FragmentStateAdapter
import com.dylanc.longan.design.setupWithViewPager2
import com.example.bxc.fragment.BxcFragment
import com.example.cat.core.BaseActivity
import com.example.cat.databinding.ActivitySivaBinding
import com.example.gan.fragment.GanFragment
import com.example.ham.fragment.HamFragment
import com.xuexiang.xui.adapter.FragmentAdapter

class SivaActivity : BaseActivity<ActivitySivaBinding>() {
    override fun InitView() {
        val lInc = binding.lInc
        val vVp = lInc.vVp
        val f_bxc = BxcFragment()
        val f_gan = GanFragment()
        val f_ham = HamFragment()
        vVp.adapter = FragmentStateAdapter(f_bxc, f_gan, f_ham)
        lInc.vMtab.setupWithViewPager2(lInc.vVp, enableScroll = false) { tab, position ->

        }
        vVp.currentItem = 0
        vVp.offscreenPageLimit = 3
//        FragmentAdapter(
//            supportFragmentManager, listOf(
//                f_bxc, f_gan, f_ham
//            )
//        )
    }
}