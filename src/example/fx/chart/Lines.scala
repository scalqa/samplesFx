package example.fx; package chart; import language.implicitConversions

//SBT: runMain example.fx.chart.Lines

object Lines extends Fx.Application(1000, 500, "Chart Test"):
  app =>

  val buffer = Idx.OM[Int]().self(b =>{
    b ++= (0 <> 1)
    b.onChange(_.stream.print)

    val stream: Int.Stream = 2 <> 1000
    J.scheduleEvery(1.Second, b += stream.read).cancelIfTrue(app.isStopped)
  })

  object View extends Fx.Chart.XY.X.Lines(new Fx.Chart.Axis.X.Time(), new Fx.Chart.Axis.X.Ints("Int")):
    val Now: Time = CURRENT
    data += new Line("Seconds", (0 <>> 100).stream.map(i => (Now + i.Seconds, i)))
    data += new Line("Minutes", (0 <>> 100).stream.map(i => (Now + i.Minutes, i)))
    data += new Line("Hours",   buffer.mutableMapView(i => new ItemBase(Now + i.Hours, i), (it: ItemBase) => it.y))
