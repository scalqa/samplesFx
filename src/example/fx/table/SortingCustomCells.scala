package example.fx; package table; import language.implicitConversions

import Fx.*

//SBT: runMain example.fx.table.SortingCustomCells

object SortingCustomCells extends Application(800, 400, "TryTableSort"):

  val intStream: Stream[Int] = 1 <> 1000
  val ITEMS    : Idx.OM[Int] = Idx.OM()

  ITEMS ++= intStream.readStream(3).reverse
  ITEMS.onChange(_.stream.print) // print out events

  object Table extends Table[Int]:
    items    = ITEMS
    sortMode = Fx.Table.SortMode.Direct
    new Column[Int]("Sortable Ints", 120, i => i) {
      alignment = RIGHT
      useContextMenu((e, c) => e.actions += Action("AAAA"))
      style = "-fx-border-color: blue; -fx-border-width: 1px"
      new CustomCell[Float](_ % 2 == 0) {
        useValue(i => (i * 10).toFloat)
        alignment = LEFT
        useContextMenu((e, c) => e.actions += Action("BBBB"))
      }
    }

  object View extends Pane.Border:
    center = Pane.Flow(Table)
    top    = Pane.Flow(Button("Do", Table.rows.replaceWith(intStream.readStream(5))))

