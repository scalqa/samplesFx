package example.fx; import language.implicitConversions

val Lang = scalqa.Lang
val Val  = scalqa.Val
val Gen  = scalqa.Gen
val J    = scalqa.J
val Fx   = scalqa.Fx

export Lang.*
export Gen.*
export Gen.Request.*
export scalqa.j.vm.Predef.given

// export Val.*
// cannot simply export scalqa.Val.*, if pattern matching is required
type Stream[+A]     = scalqa.`val`.Stream[A];          val Stream     = scalqa.`val`.Stream
type Range[A]       = scalqa.`val`.Range[A];           val Range      = scalqa.`val`.Range
type Pack[A]        = scalqa.`val`.Pack[A];            val Pack       = scalqa.`val`.Pack
type Buffer[A]      = scalqa.`val`.Buffer[A];          val Buffer     = scalqa.`val`.Buffer
type Collection[+A] = scalqa.`val`.Collection[A];      val Collection = scalqa.`val`.Collection
type Idx[+A]        = scalqa.`val`.Idx[A];             val Idx        = scalqa.`val`.Idx
type Lookup[A,+B]   = scalqa.`val`.Lookup[A,B];        val Lookup     = scalqa.`val`.Lookup
type Opt[+A]        = scalqa.`val`.Opt.TYPE.DEF[A];    val Opt        = scalqa.`val`.Opt
type Pro[+A]        = scalqa.`val`.Pro[A];             val Pro        = scalqa.`val`.Pro
type Promise[+A]    = scalqa.`val`.Promise[A];         val Promise    = scalqa.`val`.Promise
type Result[+A]     = scalqa.`val`.Result.TYPE.DEF[A]; val Result     = scalqa.`val`.Result
type Set[A]         = scalqa.`val`.Set[A];             val Set        = scalqa.`val`.Set
