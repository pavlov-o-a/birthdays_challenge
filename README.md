# birthdays_challenge
The challenge was to spend on this project no more than 3 hours.

features:
- uses Android Architecture Components
- app is split into a few dynamic modules. dynamic modules can be unloaded or loaded on demand by user
saving users space and reducing downloading application size. also dynamic modules architecture
allows to add InstantApp functionality.
- app should work in both day and night themes.
- uses Android Lifecycle components (ViewModel, LiveData)
- uses coroutines


needs to add/fix if i have more time:
- add DI (Dagger or Koin) and init Managers and Interactors in application through DI in Fragments
- Initialize Dagger(or Koin) in SplashScreen and put instance in Application class.
- move all ui things(strings, colors, themes) out of app module to UI module.
- add paging if api supports
- convert date in profile and catalog using SimpleDateFormat
- add appropriate coordinator layout items behaviour for catalog (hide toolbar on scrolling)
- add dividers to recycler
- rewrite maybe to apollo library(graphQL support)
- add requests caching or local db (room, paper) to save list of persons for offline usage
- add pull to refresh functionality to catalog
- maybe switch from plugin android-extensions (deprecated)
- add more tests


![](https://github.com/pavlov-o-a/birthdays_challenge/blob/main/screenshot.jpeg)
