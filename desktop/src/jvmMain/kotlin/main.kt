import org.kodein.playground.common.App
import androidx.compose.desktop.Window
import org.kodein.di.DI
import org.kodein.playground.common.commonDI
import org.kodein.playground.common.withDI

fun main() = Window {
    val di = DI.lazy {
        import(commonDI)
    }

    withDI(di) {
        App()
    }
}