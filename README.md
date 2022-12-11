```main:```
![badge](https://github.com/nenailya/Converter/actions/workflows/gradle-test.yml/badge.svg?branch=main)
```develop:```
![badge](https://github.com/nenailya/Converter/actions/workflows/gradle-test.yml/badge.svg?branch=develop)

# Конвертер v1.1
____
Небольшой сервис, который будет конвертировать валюту. На вход отправляется сумма в исходной валюте, на выходе получается конвертированная сумма в нужной валюте.
Кроме того можно узнавать курс валют и подсчитывать курс валюты с добавлением процента к официальной ставке.

Как пользоваться:
-----------

__Просмотр текущего курса__, где

from - валюта, из которой конвертируют,

to - валюта, в которую конвертируют,

```
http://localhost:9001/converter/rate/from/{from}/to/{to}    
```
__Конвертация валюты из одной в другую__, где

from - валюта, из которой конвертируют,

to - валюта, в которую конвертируют,

х - конвертируемое число
```
http://localhost:9001/converter/convert/from/{from}/to/{to}/{х}    
```

__Конвертация валюты из одной в другую с добавлением процентов__, где

from - валюта, из которой конвертируют,

to - валюта, в которую конвертируют,

х - конвертируемое число,

percent - добавляемый процент

```
http://localhost:9001/converter/percent/from/{from}/to/{to}/{x}/{percent}    
```

При помощи докера:
-----------

```
docker build -t converter .
docker run -it --rm -p 9001:9001 converter   
```


