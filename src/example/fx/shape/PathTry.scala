package example.fx; package shape; import language.implicitConversions

//SBT: runMain example.fx.shape.PathTry

object PathTry extends Fx.Application(600, 400, "Try Path"):

  import Fx.Shape.*
  import Path.*

  object View extends Fx.Pane.Flow:
    children +=
      Path(
        MoveTo(300, 300),
        HLineTo(70),
        QuadCurveTo().self(i => { i.x = 120; i.y = 60; i.controlX = 100; i.controlY = 0; }),
        LineTo(175, 55),
        ArcTo().self(i => { i.x = 50; i.y = 50; i.radiusX = 50; i.radiusY = 50 }))


