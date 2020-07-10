package com.example.kotlinmvvmmultidadabindingconcept

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinmvvmmultidadabindingconcept.factory.DaggerViewModelFactory
import com.example.kotlinmvvmmultidadabindingconcept.viewmodel.ViewModel1
import com.example.kotlinmvvmmultidadabindingconcept.viewmodel.ViewModel2
import dagger.Binds
import dagger.Component
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory:ViewModelProvider.Factory
    lateinit var viewModel1: ViewModel1
    lateinit var videoModel2: ViewModel2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMyComponent.create().inject(this)
        viewModel1=ViewModelProviders.of(this,factory).get(ViewModel1::class.java)
        videoModel2=ViewModelProviders.of(this,factory).get(ViewModel2::class.java)

        viewModel1.callData()
        viewModel1.getMutableDataString().observe(this, Observer {
            text1.setText(it)
        })

        videoModel2.callData()
        videoModel2.getMutableDataString().observe(this, Observer {
            text2.setText(it)
        })

    }

}
@Component(modules = [MultibindModule::class])
interface  MyComponent{
    fun inject(activity: MainActivity)
}

@Module
internal  abstract class MultibindModule
{
    @Binds
    abstract fun bindViewModelfactory(factory:DaggerViewModelFactory):ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ViewModel1::class)
    abstract fun bindMainViewModel1(viewmodel:ViewModel1):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModel2::class)
    abstract fun bindMainViewModel2(viewmodel:ViewModel2):ViewModel
}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)