# Mobile Developer Coding Challenge

## The Result


| Podcasts List Screen | Details Screen| About Screen | Tech Stack Screen |
| --- | --- | --- | --- |
| ![Screenshot_1699270357](https://github.com/MaxwellEdisonBay/mobile-coding-challenge/assets/68398572/acac3eba-c78c-4008-a10a-da82a8e24606) | ![Screenshot_1699399330](https://github.com/MaxwellEdisonBay/mobile-coding-challenge/assets/68398572/f1f01632-7743-45e5-980b-85b3d3666ba6) | ![Screenshot_1699399336](https://github.com/MaxwellEdisonBay/mobile-coding-challenge/assets/68398572/6de3aa74-6776-4a6e-a826-a96e76319dee) | ![Screenshot_1699399340](https://github.com/MaxwellEdisonBay/mobile-coding-challenge/assets/68398572/51d4ebfe-9ba7-426b-8c02-f0bc9436507a)|

#### Screen 1

- [ ] Show a list of podcasts using the endpoint provided below.
- [ ] Each list item should show the podcast thumbnail, title, and publisher name.
- [ ] Leave some space for the "Favourited" label (refer to the second podcast in the list in the mockup above).
- [ ] Show the Favourited label only if the podcast has been favourited, otherwise hide the label.

#### Screen 2

- [ ] Tapping on a list item from Screen 1 should bring you to Screen 2.
- [ ] On Screen 2, show the podcast's title, publisher name, thumbnail, and description.
- [ ] Add a Favourite button.
- [ ] The Favourite button should have two states: Favourite and Favourited.
- [ ] When tapping the Favourite button, the label should change to Favourited, and vice-versa.

## Details

- [ ] Fork this repo and keep it public until we've been able to review it.
- [ ] Must be written in Kotlin and use Jetpack Compose for UI for Android applicants, and Objective-C or Swift for iOS applicants. For iOS applicants, please use UIKit.
- [ ] For the API, use data provided by Listen Notes:
	 - [ ] Use the following endpoint to fetch podcast data: https://www.listennotes.com/api/docs/?lang=kotlin&test=1#get-api-v2-best_podcasts
	 - [ ] No API key required, you can simply use the mock server to fetch test data. [More information here](https://www.listennotes.help/article/48-how-to-test-the-podcast-api-without-an-api-key "More information here").
- [ ] Focus on implementing the app in portrait orientation only.
- [ ] The list should support pagination, loading 10 items at a time.
- [ ] Favourite state should be persistent.

## Technologies

- Jetpack Compose
- Navigation Compose
- Retrofit 2
- Kotlin Coroutines
- Coil
- Dagger/Hilt

