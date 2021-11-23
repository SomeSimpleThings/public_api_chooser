package com.somethingsimple.core_impl.component

import com.somethingsimple.core_api.di.provider.NetworkProvider
import com.somethingsimple.core_impl.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent : NetworkProvider {

}