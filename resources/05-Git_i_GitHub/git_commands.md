# System kontroli wersji (VCS)
System kontroli wersji (VCS) w programowaniu to narzędzie, które pomaga programistom zarządzać zmianami wprowadzanymi w kodzie źródłowym na przestrzeni czasu. Umożliwia współpracę wielu developerów nad jednym projektem, śledzenie zmian oraz powrót do wcześniejszych wersji, jeśli zajdzie taka potrzeba.
Główne funkcje systemu kontroli wersji to:

Repozytoria: Miejsca przechowywania kodu oraz jego historii zmian.
Commity: Migawki wprowadzonych zmian w kodzie.
Gałęzie (branche): Niezależne linie rozwoju kodu, które można scalać ze sobą.
Scalanie (merge): Łączenie zmian z różnych gałęzi.
Pull/Push: Synchronizacja zmian między lokalnym a zdalnym repozytorium.

# Przykłady projektów, w których systemy kontroli wersji odegrały kluczową rolę
* Jądro systemu Linux: Rozwój jądra Linux angażuje tysiące współtwórców na całym świecie. Systemy kontroli wersji, zwłaszcza Git, są niezbędne do zarządzania tą ogromną współpracą.
* Apache Software Foundation: Projekty takie jak Apache HTTP Server czy Apache Hadoop opierają się na systemach kontroli wersji, aby umożliwić współpracę zespołową oraz efektywne zarządzanie wydaniami.
* Microsoft Windows: Tworzenie systemu Windows wymaga pracy dużego zespołu developerów. Systemy kontroli wersji są wykorzystywane do zarządzania skomplikowaną bazą kodu oraz zapewnienia śledzenia i koordynacji zmian.

# Korzyści z używania systemów kontroli wersji
* Poprawa współpracy: Systemy kontroli wersji ułatwiają pracę zespołową, umożliwiając wielu developerom pracę nad tym samym kodem źródłowym jednocześnie.
* Śledzenie historii: Wszelkie zmiany wprowadzone w kodzie są rejestrowane, co pozwala łatwo sprawdzić, kto, kiedy i jakie zmiany wprowadził.
* Możliwość wycofywania zmian: W przypadku wprowadzenia błędu deweloperzy mogą powrócić do wcześniejszej wersji kodu, aby naprawić problem.
* Gałęzie i scalanie: Systemy kontroli wersji umożliwiają pracę nad różnymi funkcjonalnościami lub poprawkami niezależnie, a następnie scalenie ich z główną wersją kodu, gdy są gotowe.

# CVS vs SVN vs git
* CVS: Concurrent Version System, operuje na plikach (problemy ze zmianą nazw), identyfikatory: liczby
* SVN: Apache Subversion, operuje na plikach (ale zmiana nazw możliwa, identyfikatory: liczby
* Git: Git, operuje na tekście, identyfikatory: SHA-1

# Motywacje stojące za rozwojem Gita
* Wydajność: Git został zaprojektowany, aby efektywnie obsługiwać duże projekty, takie jak jądro systemu Linux, które angażuje tysiące współtwórców i ogromną bazę kodu.
* Rozproszony przepływ pracy: Proces rozwoju jądra Linux jest wysoce rozproszony, z udziałem programistów z całego świata. Rozproszony charakter Gita umożliwia developerom pracę niezależnie i późniejszą synchronizację zmian.
* Gałęzie i scalanie: Git oferuje bardziej wydajne i zaawansowane możliwości tworzenia gałęzi i scalania w porównaniu z istniejącymi systemami, takimi jak CVS i SVN.
* Integralność danych: Git wykorzystuje mechanizm skrótów (SHA-1), aby zapewnić integralność danych, co było znaczną poprawą w stosunku do istniejących rozwiązań.
* Szybkość: Git został zaprojektowany z myślą o szybkości, szczególnie w przypadku operacji takich jak commity, tworzenie gałęzi i scalanie.
* Operacje lokalne: Git umożliwia wykonywanie większości operacji lokalnie, zmniejszając potrzebę łączenia się z centralnym serwerem i pozwalając na pracę offline.

# Commands

### init
Gdy uruchamiasz polecenie git init w folderze, Git tworzy w nim nowe repozytorium. Dodatkowo, tworzony jest podfolder .git, który zawiera wszystkie metadane i obiekty niezbędne do zarządzania repozytorium.
Początkowe pliki i katalogi:
* `objects/` – Przechowuje wszystkie dane Twojego repozytorium.
* `refs/` – Zawiera wskaźniki do commitów w repozytorium.
* `HEAD` – Plik wskazujący na aktualną gałąź, na której pracujesz.
* `config` – Plik zawierający ustawienia konfiguracyjne dla repozytorium.

### clone
Polecenie `git clone` tworzy lokalną kopię zdalnego repozytorium, co jest przydatne przy pracy nad projektem hostowanym na serwerze, takim jak GitHub czy GitLab.
Jak działa `git clone`?
Musisz podać adres URL zdalnego repozytorium, które chcesz skopiować, np.:
`git clone https://github.com/użytkownik/repozytorium.git`
Domyślnie git clone tworzy nowy katalog o nazwie repozytorium. Możesz jednak określić inną nazwę katalogu, dodając ją jako argument:
`git clone https://github.com/użytkownik/repozytorium.git nowa_nazwa_katalogu`
Polecenie ściąga wszystkie pliki i metadane ze zdalnego repozytorium na Twój komputer, w tym wszystkie gałęzie, tagi i historię commitów.
Po sklonowaniu Git konfiguruje śledzone gałęzie zdalne, dzięki czemu możesz synchronizować lokalne repozytorium ze zdalnym za pomocą poleceń takich jak git fetch i git pull.
### config
Konfiguracja Gita pozwala dostosować różne aspekty środowiska Git. Możesz ustawić konfigurację globalną (dla wszystkich repozytoriów) lub lokalną (tylko dla konkretnego repozytorium).
Podstawowe polecenia:

Wyświetlenie aktualnej konfiguracji: `git config --list`
Ustawienie konfiguracji globalnej: `git config --global <klucz> <wartość>`
Przykład: `git config --global user.email "twój.email@przyklad.com"`

Ustawienie konfiguracji lokalnej (dla bieżącego repozytorium): `git config <klucz> <wartość>`
Przykład: `git config user.name "Twoje Imię"`

Pliki konfiguracyjne:
Poziom systemowy: `/etc/gitconfig`
Poziom globalny: `~/.gitconfig` lub `~/.config/git/config`
Poziom lokalny: `.git/config` (w katalogu repozytorium)

### checkout
Polecenie **`git checkout`** służy do kilku celów, takich jak przełączanie gałęzi, przywracanie plików oraz przechodzenie do konkretnych commitów.
- **`git checkout <nazwa_gałęzi>`** – przełącza się na podaną gałąź.
- **`git checkout <hash_commita>`** – przechodzi do konkretnego commita.
- **`git checkout -b <nazwa_gałęzi>`** – tworzy nową gałąź i natychmiast się na nią przełącza.
- **`git checkout -- <nazwa_pliku>`** – przywraca plik do stanu z ostatniego commita.

### branch
Polecenie **`git branch`** służy do wyświetlania, tworzenia i usuwania gałęzi w repozytorium Git.
- **`git branch`** – wyświetla listę wszystkich gałęzi.
- **`git branch <nazwa_gałęzi>`** – tworzy nową gałąź.
- **`git branch -d <nazwa_gałęzi>`** – usuwa wskazaną gałąź.
- **`git branch -m <stara_nazwa> <nowa_nazwa>`** – zmienia nazwę gałęzi.

### status
Polecenie **`git status`** wyświetla **aktualny stan repozytorium**, pokazując:
- **zmodyfikowane pliki**,
- **pliki przygotowane do commita** (staging area),
- **pliki nieśledzone**,
- **stan gałęzi** (czy jest zsynchronizowana ze zdalnym repozytorium).
- **`git status`** – pokazuje **pełny stan** repozytorium.
- **`git status -s`** – wyświetla informacje w **skróconej, zwięzłej formie**.
- **`git status --branch`** – dodatkowo wyświetla informacje o **relacjach między gałęziami**.

### add
Polecenie **`git add`** dodaje zmiany do **staging area** (obszaru przygotowań), czyli listy zmian, które zostaną uwzględnione w następnym commicie.
- **`git add <nazwa_pliku>`** – dodaje wskazany plik do staging area.
- **`git add .`** – dodaje wszystkie zmiany w bieżącym katalogu do staging area.
- **`git add -A`** – dodaje wszystkie zmiany (w tym usunięcia plików) w całym repozytorium do staging area.

#### Podstawowe obszary w Git: Working Directory i Staging Area
**Working Directory (Katalog roboczy):**
Jest to katalog, w którym wprowadzasz zmiany w plikach – edytujesz, tworysz lub usuwasz je. Zawiera **aktualny stan Twojego projektu**.

**Staging Area (Obszar przygotowań):**
To **pośredni obszar**, w którym zmiany są przygotowywane przed zatwierdzeniem (commitem). Po użyciu polecenia **`git add`**, zmiany przenoszone są z katalogu roboczego do staging area. Dzięki temu możesz **selektywnie wybierać zmiany** i sprawdzać je przed wykonaniem commita.

#### Przywracanie zmian z staging area za pomocą `git reset`:
Jeśli się rozmyślisz, możesz **cofnąć** zmiany z staging area:
- **`git reset <nazwa_pliku>`** – cofa zmiany dla wskazanego pliku.
- **`git reset`** – cofa wszystkie zmiany z staging area.

### commit
Polecenie **`git commit`** tworzy **commit aktualnego stanu plików** i zapisuje ją w historii repozytorium. Zatwierdza **tylko zmiany, które zostały przygotowane** (dodane za pomocą `git add`). Każdy commit wymaga **komentarza opisującego wprowadzone zmiany**.
- **`git commit -m "Twój komunikat commita"`** – zatwierdza przygotowane zmiany z podanym komentarzem.
- **`git commit -am "Twój komunikat commita"`** – zatwierdza **wszystkie zmiany w katalogu roboczym** (nie dotyczy nowych plików, które nadal wymagają `git add`).
- **`git commit --amend`** – **modyfikuje ostatni commit** (np. poprawia komunikat lub dodaje zapomniane zmiany).

### push
Polecenie **`git push`** przesyła **lokalne commity** do zdalnego repozytorium, udostępniając je innym developerom.
- **`git push origin <nazwa_gałęzi>`** – wysyła wskazaną gałąź do zdalnego repozytorium.
- **`git push`** – po ustawieniu powiązania między lokalną a zdalną gałęzią (za pomocą `git push -u origin <nazwa_gałęzi>`), wysyła **bieżącą gałąź** do zdalnego repozytorium.
- **`git push -f`** – wymusza wysłanie, **nadpisując zmiany** w zdalnym repozytorium (uważaj na utratę danych!).
- **`git push --force-with-lease`** – wymusza wysłanie, ale **tylko jeśli zdalna gałąź nie została zmieniona** od ostatniego pusha (bezpieczniejsza alternatywa dla `-f`).
- **`git push --set-upstream origin <nazwa_gałęzi>`** – ustawia **śledzenie** dla bieżącej gałęzi i wysyła ją do zdalnego repozytorium.
- **`git push --delete origin <nazwa_gałęzi>`** – **usuwa** wskazaną gałąź z zdalnego repozytorium.
- **`git push --tags`** – wysyła **wszystkie tagi** do zdalnego repozytorium.
- **`git push --all`** – wysyła **wszystkie gałęzie** do zdalnego repozytorium.

### pull
Polecenie **`git pull`** pobiera zmiany ze **zdalnego repozytorium** i natychmiast aktualizuje lokalne repozytorium, dopasowując je do zdalnej wersji.
- **`git pull <nazwa_zdalnego> <nazwa_gałęzi>`** – pobiera zmiany z **konkretnej gałęzi zdalnego repozytorium**.
- **`git pull`** – pobiera zmiany z **domyślnego zdalnego repozytorium i domyślnej gałęzi**.
- **`git pull --rebase`** – pobiera zmiany, ale **przebudowuje lokalne commity na wierzchu zdalnej gałęzi** zamiast scalać (unika niepotrzebnych commitów merge).

### Kiedy zdarzają się konflikty?
- **Jednoczesne zmiany:** Gdy wielu developerów pracuje nad tym samym plikiem i wprowadza zmiany w tych samych liniach kodu, **konflikty mogą wystąpić** podczas próby scalenia lub wysłania zmian.
- **Niesynchronizowane gałęzie:** Jeśli Twoja lokalna gałąź nie jest zaktualizowana względem zdalnej i wprowadzasz zmiany, które kolidują z zmianami innych, **konflikty mogą pojawić się** podczas próby wysłania swoich modyfikacji.
- **Scalanie gałęzi:** Podczas łączenia gałęzi zawierających zmiany w tej samej części pliku **konflikty mogą powstać**, jeśli zmiany nie są ze sobą kompatybilne.

### Jak unikać i rozwiązywać konflikty?
- **Komunikacja:** Utrzymuj **otwartą komunikację** w zespole na temat tego, kto nad czym pracuje. Pomaga to unikać sytuacji, w której wiele osób wprowadza zmiany w tym samym fragmencie kodu jednocześnie.
- **Gałęzie funkcjonalne (Feature Branches):** Korzystaj z **oddzielnych gałęzi** dla nowych funkcji lub większych zmian. Izolowanie zmian ułatwia ich zarządzanie i późniejsze scalanie.
- **Częste pobieranie zmian:** Zachęcaj członków zespołu do **regularnego pobierania zmian** ze zdalnego repozytorium. Dzięki temu lokalne gałęzie są zawsze aktualne, co zmniejsza ryzyko konfliktów.

### annotate (dawniej: blame)
Polecenie **`git annotate`** wyświetla **adnotacje dla każdej linii pliku**, pokazując:
- **autora ostatniej zmiany**,
- **hash commita**,
- **datę i godzinę modyfikacji**.
Przykład użycia:
- **`git annotate <nazwa_pliku>`** – pokazuje szczegółowe informacje o ostatnich zmianach dla każdej linii w podanym pliku.

### log
Polecenie **`git log`** wyświetla **historię commitów** w repozytorium, w tym:
- **hash commita**,
- **autora**,
- **datę**,
- **komunikat commita**.
- **`git log`** – pokazuje **pełną historię commitów**.
- **`git log --oneline`** – wyświetla historię w **skróconej formie** (jeden commit w linii).
- **`git log --graph`** – prezentuje historię w **formie graficznej** (przydatne przy gałęziach).
- **`git log -n`** – pokazuje **ostatnie n commitów** (np. `git log -5`).
- **`git lg`** – popularny alias dla `git log --oneline --decorate --graph --all` (wymaga konfiguracji).

### cherry-pick
Polecenie **`git cherry-pick`** pozwala **zastosować zmiany z konkretnego commita** na bieżącej gałęzi.
- **`git cherry-pick <hash_commita>`** – przenosi zmiany z podanego commita na bieżącą gałąź.
- **`git cherry-pick -n <hash_commita>`** – przenosi zmiany **bez automatycznego commita** (pozwala na dodatkowe modyfikacje).
- **`git cherry-pick --continue`** – kontynuuje operację po rozwiązaniu konfliktów.
- **`git cherry-pick --abort`** – przerywa operację cherry-pick.
- **`git cherry-pick --edit`** – umożliwia **edycję komunikatu commita** przed zatwierdzeniem zmian.

### reset
Polecenie **`git reset`** pozwala **cofnąć zmiany** w repozytorium, przestawiając wskaźnik HEAD oraz – opcjonalnie – stan staging area lub katalogu roboczego do wskazanego commita.
- **`git reset --soft <hash_commita>`** – cofa wskaźnik HEAD do podanego commita, **zachowując zmiany** w staging area i katalogu roboczym.
- **`git reset --mixed <hash_commita>`** – cofa wskaźnik HEAD i **usuwa zmiany ze staging area** (domyślne zachowanie), ale zachowuje je w katalogu roboczym.
- **`git reset --hard <hash_commita>`** – cofa wskaźnik HEAD, **usuwa zmiany** zarówno ze staging area, jak i z katalogu roboczego (uwaga: nieodwracalne!).
- **`git reset <nazwa_pliku>`** – usuwa wskazany plik **ze staging area**, zachowując zmiany w katalogu roboczym.
- **`git reset --merge`** – przerywa operacje takie jak merge lub rebase, zachowując zmiany w katalogu roboczym.

### merge
Polecenie **`git merge`** łączy zmiany z **jednej gałęzi** z **bieżącą gałęzią**, tworząc nowy commit scalenia, jeśli jest to konieczne.
- **`git merge <nazwa_gałęzi>`** – scala wskazaną gałąź z bieżącą, tworząc commit scalenia (jeśli nie ma konfliktów).
- **`git merge --no-ff <nazwa_gałęzi>`** – zawsze tworzy **commit scalenia**, nawet jeśli możliwe jest szybkie przesunięcie (fast-forward).
- **`git merge --squash <nazwa_gałęzi>`** – scala zmiany jako **pojedynczy nowy commit**, bez automatycznego zatwierdzania.
- **`git merge --continue`** – kontynuuje scalanie po rozwiązaniu konfliktów.
- **`git merge --abort`** – przerywa scalanie i przywraca stan sprzed rozpoczęcia operacji.

### rebase
Polecenie **`git rebase`** pozwala **przenosić, łączyć lub modyfikować sekwencję commitów**, umieszczając je na nowej podstawie. Umożliwia utrzymanie **czystszej, liniowej historii projektu**.
- **`git rebase <nazwa_gałęzi>`** – przenosi commity z bieżącej gałęzi **na wierzch wskazanej gałęzi**, zapewniając liniową historię.
- **`git rebase -i <nazwa_gałęzi>`** – uruchamia **interaktywny rebase**, umożliwiając edycję, scalanie lub zmianę kolejności commitów przed ich ponownym zastosowaniem.
- **`git rebase --continue`** – kontynuuje operację rebase po rozwiązaniu konfliktów.
- **`git rebase --abort`** – przerywa rebase i przywraca gałąź do stanu sprzed rozpoczęcia operacji.

YouTube:
1. Merge vs rebase: https://www.youtube.com/watch?v=dWT9cr0A-JY
2. Interkatywny rebase: https://www.youtube.com/watch?v=6NYVXNoBYz8
2. Git i GitHub w 60 minut:  https://www.youtube.com/watch?v=Ebe9D5zRkvM



