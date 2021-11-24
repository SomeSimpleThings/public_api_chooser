package com.somethingsimple.publicapichooser.schedulers

import com.somethingsimple.core_api.common.DefaultSchedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

object DefaultSchedulersImpl : DefaultSchedulers {

    override fun background(): Scheduler = io.reactivex.rxjava3.schedulers.Schedulers.newThread()
    override fun main(): Scheduler = AndroidSchedulers.mainThread()
    override fun trampoline(): Scheduler = io.reactivex.rxjava3.schedulers.Schedulers.trampoline()
    override fun computation(): Scheduler = io.reactivex.rxjava3.schedulers.Schedulers.computation()

}