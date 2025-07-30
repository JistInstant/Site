document.addEventListener('DOMContentLoaded', () => {
  // Замените URL на ваши настоящие ссылки из Cloudinary:
  const posters = [
    'https://res.cloudinary.com/dptqp3lut/image/upload/v1750150834/one-piece-poster-3840x2160-16685_yzphhq.jpg',
    'https://res.cloudinary.com/dptqp3lut/image/upload/v1750153974/Naruto_euox5v.jpg',
    'https://res.cloudinary.com/dptqp3lut/image/upload/v1750153989/bleach_cr83uk.jpg'
  ];

  const alts = ['One Piece', 'Naruto', 'Bleach'];
  const img = document.getElementById('carousel-image');
  let idx = 0;

  // Устанавливаем первый кадр
  img.src = posters[0];
  img.alt = alts[0];

  setInterval(() => {
    // 1) запускаем fade-out
    img.style.opacity = 0;

    // 2) после 1s (когда закончится transition) меняем картинку и fade-in
    setTimeout(() => {
      idx = (idx + 1) % posters.length;
      img.src = posters[idx];
      img.alt = alts[idx];
      img.style.opacity = 1;
    }, 1000); // совпадает с transition-duration
  }, 7000);
});
