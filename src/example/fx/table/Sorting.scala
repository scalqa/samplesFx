package example.fx; package table; import language.implicitConversions

import Fx.*

//SBT: runMain example.fx.table.Sorting

object Sorting extends Application(800, 401, "TryTableSort"):

  val intStream: Int.Stream  = 1 <> 1000
  val ITEMS    : Idx.OM[Int] = Idx.OM()

  ITEMS ++= intStream.readStream(6).reverseEvery(3)
  ITEMS.onChange(_.stream.print) // print out events

  object SortableTable extends Table[Int]:
    new Column[Int]   ("Sortable Ints ",   120, i => i)
    new Column[String]("Sortable Strings", 120, i => (1000 - i).toString)
    items    = ITEMS
    sortMode = Table.SortMode.Direct
    sortModePro.onValueChange(v => "Sorting Changed to: " + v tp())

  object ControlTable extends Table[Int]:
    new Column[Int]("True Ints", 150, v => v)
    items    = ITEMS
    sortMode = VOID

  object View extends Pane.Border:
    center = Pane.Flow(SortableTable, ControlTable)
    top    = Pane.Flow(
      ComboBox(Table.SortMode.stream, SortableTable.sortMode).self(_.valuePro.onValueChange(v => SortableTable.sortMode = v)),
      Button("Delete first two",        ITEMS.modify(_.removeRange(0 <> 1))).self(b => ITEMS.onChange(_ => b.disable = ITEMS.size < 2)),
      Button("Append next 5",           ITEMS ++= intStream.readStream(5)),
      Button("Replace All with next 5", ITEMS.replaceWith(intStream.readStream(5))),
      Button("Clear All",               ITEMS.clear),
      Button("Sort",                    ITEMS.sort),
      Button("Sort Reversed",           ITEMS.sortReversed))


