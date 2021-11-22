package com.somethingsimple.publicapichooser.schedulers

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

object DefaultSchedulers : Schedulers {

    override fun background(): Scheduler = io.reactivex.rxjava3.schedulers.Schedulers.newThread()

    override fun main(): Scheduler = AndroidSchedulers.mainThread()

    override fun trampoline(): Scheduler = io.reactivex.rxjava3.schedulers.Schedulers.trampoline()
}

interface Schedulers {

    fun background(): Scheduler
    fun main(): Scheduler
    fun trampoline(): Scheduler

}
