# 1. Ödev

## Soru 1 - Fibonacci Serisi -> `Fibonacci.java`

Özyineli (recursive) fonksiyon kullanarak fibonacci serisinin ilk `n` karakterini ekrana yazdıran programı yazınız. Fibonacci serisinin eleman sayısını (`n`) `java.util.Random` sınıfını kullanarak oluşturabilirsiniz.

### Fibonacci Serisi Nedir?
Fibonacci serisi, her sayının kendinden önceki ile toplanması sonucu oluşan bir sayı dizisidir. Bu şekilde devam eden bu dizide sayılar birbirleriyle oranlandığında altın oran ortaya çıkar, yani bir sayı kendisinden önceki sayıya bölündüğünde altın orana gittikçe yaklaşan bir dizi elde edilir.

Fibonacci dizisi, 0'dan başlar ve sonsuza kadar. Her rakam, bir önceki rakamla toplanır. Elde edilen sonuç rakamın sağ tarafına yazılır. Fibonacci dizisinin ilk on sayısı şu şekildedir: 
> 0 1 1 2 3 5 8 13 21 34

Bu da bir Fibonacci dizisidir:
> 4, 4, 8, 12, 20, 32, 52, … 

Çünkü Fibonacci dizisi herhangi iki sayıdan başlayabilir.


- ***Kaynak*** : [Wikipedia](https://tr.wikipedia.org/wiki/Fibonacci_dizisi)

### Örnek çıktılar:

```cmd
Generated number: 23
First 23 fibonacci number:
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 
```

```cmd
Generated number: 16
First 16 fibonacci number:
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
```
---

## Soru 2 - Okul puanlarının harf notu karşılığı -> `LetterGrade.java`
`java.util.Random` sınıfı kullanılarak oluşturulan okul puanının aşağıdaki durumlara göre harf karşılığını ekrana yazdıran programı yazınız.

- 0 - 35 arası FF
- 35 - 50 arası DC
- 50 - 70 arası BB
- 70 - 100 arası AA

### Örnek çıktılar:
```cmd
Harith's score: 27
Harith's letter grade: FF
```
```cmd
Harith's score: 85
Harith's letter grade: AA
```
---
## Soru 3 - Manav Kasa Programı -> `GreenGrocer.java`
Java ile kullanıcıların manavdan almış oldukları ürünlerin kilogram değerlerine göre toplam tutarını ekrana yazdıran programı yazınız.

Meyveler ve KG Fiyatları:

- Armut : 2,14 TL
- Elma : 3,67 TL
- Domates : 1,11 TL
- Muz: 0,95 TL
- Patlıcan : 5,00 TL

### Örnek çıktı:
```cmd
Weight of pear in kgs: A
Weight value must be a number
Weight of pear in kgs: 2
Weight of apple in kgs: 1,5
Weight of tomato in kgs: 3
Weight of banana in kgs: 1
Weight of eggplant in kgs: 1
Total price 19,06
```
