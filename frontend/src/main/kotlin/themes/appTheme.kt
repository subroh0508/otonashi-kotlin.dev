package themes

import kotlinx.css.Color
import materialui.styles.createMuiTheme
import materialui.styles.muitheme.MuiTheme
import materialui.styles.muitheme.options.palette
import materialui.styles.palette.options.*

val appTheme: MuiTheme = createMuiTheme {
    palette {
        primary {
            main = Color("#f88909")
            light = Color("#ffba47")
            dark = Color("#bf5b00")
        }
        secondary {
            main = Color("#147dfe")
            light = Color("#6dabff")
            dark = Color("#0052ca")
        }
    }
}
