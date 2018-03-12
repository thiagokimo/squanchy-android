package net.squanchy.search;

import net.squanchy.search.engines.SearchEngines;
import net.squanchy.service.firestore.FirebaseAuthService;
import net.squanchy.service.repository.firestore.EventRepository;
import net.squanchy.service.repository.firestore.SpeakerRepository;

import dagger.Module;
import dagger.Provides;

@Module
class SearchModule {

    @Provides
    SearchEngines searchEngines() {
        return new SearchEngines();
    }

    @Provides
    SearchService searchService(
            EventRepository eventRepository,
            SpeakerRepository speakerRepository,
            SearchEngines searchEngines,
            FirebaseAuthService authService
    ) {
        return new SearchService(eventRepository, speakerRepository, searchEngines, authService);
    }
}
