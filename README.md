# Performance Benchmarking

This repository benchmarks the performance of the MOEA Framework.  This helps monitor for any changes that affect performance.

## Benchmarks

All benchmarks are based on the 2-D DTLZ2 problem with `100,000` function evaluations (NFE) and `10` seeds.  Below details each of the benchmarks.
See [Timings](Timings.md) for collected timing data.

Benchmark                  | Description
-------------------------- | -----------
C (pure)                   | Pure C implementation, measuring evaluation time without overhead
Java                       | Pure Java implementation, measuring evaluation time without overhead
NativeC                    | JNA native library written in C
NativeCPP                  | JNA native library written in C++
NativeFortran              | JNA native library written in Fortran
NativeCDirectMapping       | JNA direct mapping written in C (less overhead)
NativeCPPDirectMapping     | JNA direct mapping written in C++ (less overhead)
NativeFortranDirectMapping | JNA direct mapping written in Fortran (less overhead)
C (stdio)                  | `ExternalProblem` written in C using Standard I/O
C (socket)                 | `ExternalProblem` written in C using Sockets
Python (stdio)             | `ExternalProblem` written in Python using Standard I/O
Python (socket)            | `ExternalProblem` written in Python using Sockets
Pypy (stdio)               | Same as "Python (stdio)" but using the `pypy` JIT compiler
Pypy (socket)              | Same as "Python (socket)" but using the `pypy` JIT compiler
JMetal (Direct)            | JMetal's implementation, calling JMetal's NSGA-II and DTLZ2 code directly
JMetal (Plugin)            | JMetal's implementation, using `JMetal-Plugin` to create instances

## License

Copyright 2009-2024 David Hadka and other contributors.  All rights reserved.

The MOEA Framework is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or (at your
option) any later version.

The MOEA Framework is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
License for more details.

You should have received a copy of the GNU Lesser General Public License
along with the MOEA Framework.  If not, see <http://www.gnu.org/licenses/>.
