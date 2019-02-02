# type_int

| val  | encoded             | comment |
| ---- | ------------------- | ------- |
| 31  | `"\b;;;;;;Z"` |         |
| 2147483647  | `"\b<ZZZZZZ"` |         |
| -2147483648  | `"\b=;;;;;;"` |         |

# type_long

| val  | encoded             | comment |
| ---- | ------------------- | ------- |
| 31  | `"\b;;;;;;;;;;;;;Z"`            |         |
| 256  | `"\b;;;;;;;;;;;;C;"`            |         |
| 1984 | `"\b;;;;;;;;;;;<Y;"`           |         |
| 0    | `"\b;;;;;;;;;;;;;;"`             |         |
| 1    | `"\b;;;;;;;;;;;;;<"`             |         |
| -1   | `"\b<JZZZZZZZZZZZZ"` |         |
| -2   | `"\b<JZZZZZZZZZZZY"` |         |
| 9223372036854775807   | `"\b;BZZZZZZZZZZZZ"` |         |
| -9223372036854775808   | `"\b<C;;;;;;;;;;;;"` |         |

# type_double

| val  | encoded             | comment |
| ---- | ------------------- | ------- |
| 0.0  | `"\f;;;;;;;;;;;;;;"`               |         |
| 1.0  | `"\f;>ZW;;;;;;;;;;"` |         |
| 1.1  | `"\f;>ZWGTNAGTNAGU"` |         |

# type_string

| val  | encoded             | comment |
| ---- | ------------------- | ------- |
| `hello`  | `"hello"`               |         |
| `中文`  | `"中文"` |         |
| `𐐷` | `"𐐷"` | |
| `𤭢` | `"𤭢"` | |
| `🙏` | `"🙏"` | |
| `"` | `"\\CC"` | |
| `\` | `"\\FM"` | |
| `/` | `"\\CP"` | |
| 0x00 | `"\\AA"` | |
| `h"e"l"l"o` | `"h\\CCe\\CCl\\CCl\\CCo"` | |

# type_bytes

| val | encoded | comment |
| --- | ---     | ---     |
| `[]`  | `""`  |     |
| `[00]`  | `"\\AA"`  |     |
| `[20 00 20]`  | `" \\AA "`  |     |
| `[E4 B8 AD]`  | `"中"`  |     |
| `[E4 00 00]`  | `"\\?E\\AA\\AA"`  |     |
| `[ED 9F BF]`  | `"\\?N\\:P\\<P"`  |     |