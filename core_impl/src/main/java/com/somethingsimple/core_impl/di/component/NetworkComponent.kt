package com.somethingsimple.core_impl.di.component

import com.somethingsimple.core_api.di.provider.NetworkDataSourceProvider
import com.somethingsimple.core_impl.di.module.NetworkDataSourceModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkDataSourceModule::class])
interface NetworkComponent : NetworkDataSourceProvider {

}