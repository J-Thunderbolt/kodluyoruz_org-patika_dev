# Ödev 1

## Javascript Saat ve Karşılama

![clock](figures/clock.gif)

Basitçe sizden girişte isminizi isteyip sonra bu ismi karşılama ekranına yerleştirerek o anki saati ve günü gösteren bir ekran.

- Yazacağınız Javascript dosyasında **Date** methodunu kullanacaksınız. Detaylı bilgi için [tıklayınız](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Date).

- Gün olarak aldığınız değeri `string` olarak göstermeniz gerekmektedir. (**İpucu**: 1 = Pazartesi)

  - Günü almak için `toLocaleString()` metodunu kullandım.
  

- Eğer saat, dakika ya da saniye 10'dan küçükse başına 0'ı koymalısınız.

  - Saati dakika ve saniyeyi alırken `toString().padStart(2, '0')` kullanarak yaptım.
  

- Her 1 saniyede bir yenilenmelidir.

  - `setInterval()` metodunu kullanarak yaptım.
  

- Kullanıcıdan alınan ad direkt olarak ekrana yazılmalıdır.

  - prompt() ile kullanıcıdan aldığım isim bilgisini querySelector kullanarak ekrandaki ilgili yere yazdım.
