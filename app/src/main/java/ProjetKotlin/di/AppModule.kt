package ProjetKotlin.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ProjetKotlin.helpers.MemoBDDHelper
import ProjetKotlin.models.MemoDAO
import javax.inject.Singleton

@Module
class AppModule
{
    @Singleton
    @Provides
    fun provideMemoDAO(applicationContext: Context): MemoDAO
    {
        return MemoBDDHelper.getBDD(applicationContext).memoDAO()
    }

    @Provides
    fun provideContext(application: Application): Context
    {
        return application
    }
}