package example.fx; package table; import language.implicitConversions

import Fx.*

//SBT: runMain example.fx.table.SortingCustomCells

object SortingCustomCells extends Application(800, 400, "TryTableSort"):

  val intStream : ~[Int]       = 1 <> 1000
  val ITEMS      : Idx.OM[Int] = Idx.OM()

  ITEMS ++= intStream.read_~(3).reverse
  ITEMS.onChange(_.~.print) // print out events

  object Table extends Table[Int]:
    items    = ITEMS
    sortMode = Fx.Table.SortMode.Direct
    new Column[Int]("Sortable Ints", 120, i => i) {
      alignment = RIGHT
      contextMenu_:((e, c) => e.actions += Action("AAAA"))
      style = "-fx-border-color: blue; -fx-border-width: 1px"
      new CustomCell[Float](_ % 2 == 0) {
        value_:(i => (i * 10).toFloat)
        alignment = LEFT
        contextMenu_:((e, c) => e.actions += Action("BBBB"))
      }
    }

  object View extends Pane.Border:
    center = Pane.Flow(Table)
    top    = Pane.Flow(Button("Do", Table.rows.replaceWith(intStream.read_~(5))))

