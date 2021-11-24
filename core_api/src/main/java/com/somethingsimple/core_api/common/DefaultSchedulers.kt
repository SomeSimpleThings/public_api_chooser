package com.somethingsimple.core_api.common

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

interface DefaultSchedulers {

    fun background(): Scheduler
    fun main(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler

}

object DefaultSchedulersImpl : DefaultSchedulers {

    override fun background(): Scheduler = io.reactivex.rxjava3.schedulers.Schedulers.newThread()
    override fun main(): Scheduler = AndroidSchedulers.mainThread()
    override fun trampoline(): Scheduler = io.reactivex.rxjava3.schedulers.Schedulers.trampoline()
    override fun computation(): Scheduler = io.reactivex.rxjava3.schedulers.Schedulers.computation()

}
