package ProjetKotlin.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ProjetKotlin.main.MainRepository
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
public interface AppComponent
{
    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(mainRepository: MainRepository)
}