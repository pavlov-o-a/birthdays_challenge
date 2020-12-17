# birthdays_challenge
installation:
    build through Android studio. Should be one button click.

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

links:
    - https://github.com/pavlov-o-a
    - https://codeberg.org/Freeyourgadget/Gadgetbridge/pulls/2021 - pull request to open source project
        i have cracked sony swr12 band application and added initial support to application (steps,
        alarms, etc.)
    - https://play.google.com/store/apps/details?id=ru.mts.books.droid - application from my current
    place of work. 1M+ downloads, 300K installed RN.

me:
    Oleg Pavlov
    forpoststuff@gmail.com
    +7(981)995-65-79
    Saint-Petersburg, Russia