package net.squanchy.search

import dagger.Module
import dagger.Provides
import net.squanchy.search.algolia.AlgoliaSearchEngine
import net.squanchy.service.repository.AuthService
import net.squanchy.service.repository.EventRepository
import net.squanchy.service.repository.SpeakerRepository

@Module
class SearchModule {

    @Provides
    fun searchService(
        eventRepository: EventRepository,
        speakerRepository: SpeakerRepository,
        authService: AuthService,
        algoliaSearchEngine: AlgoliaSearchEngine
    ): SearchService {
        return SearchService(eventRepository, speakerRepository, authService, algoliaSearchEngine)
    }
}
