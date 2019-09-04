package mx.yellowme.youst.playground.nemo.navigator.fetchers

import mx.yellowme.youst.playground.nemo.navigator.hooks.AsyncSingleNavigator
import mx.yellowme.youst.playground.nemo.navigator.hooks.Navigator
import mx.yellowme.youst.playground.nemo.navigator.BaseHelm
import mx.yellowme.youst.playground.data.ConfigFakeRepository
import mx.yellowme.youst.playground.domain.Config

class FetchConfig<Navigation>(
    private val repository: ConfigFakeRepository,
    private val navigator: Navigation
) : Navigator() where Navigation : BaseHelm {

    override fun run() {
        repository.getData(true, object : AsyncSingleNavigator<Config>(this) {
            override fun onLoad(item: Config?) {
                continueFlowIf(item?.hasSupportedVersion ?: false)
            }
        })
    }

    override fun executeExit() {
        navigator.sendToUnsupportedVersion()
    }

}
