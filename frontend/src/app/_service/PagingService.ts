export class PagingService {
  getPaging(totalItems: number, currentPage: number = 1, pageSize: number = 15) {
    let startPage: number;
    let endPage: number;
    let pages: number[];

    const totalPages = Math.ceil(totalItems / pageSize);
    if (currentPage < 1) { currentPage = 1; } else if (currentPage > totalPages) { currentPage = totalPages; }
    if (totalPages <= 10) { // pokazemy 5 przed i 4 za aktualna
      startPage = 1;
      endPage = totalPages;
    } else {
      if (currentPage <= 6) {
        startPage = 1;
        endPage = 10;
      } else if (currentPage + 4 >= totalPages) {
        // dolecielismy praktycznie do konca - pokazmy 9(=5+4) przed koncem
        startPage = totalPages - 9;
        endPage = totalPages;
      } else {
        startPage = currentPage - 5;
        endPage = currentPage + 4;
      }
    }

    // dla ng-for potrzebny jest array po numberach .keys zwraca iterator, po ktorym moze chodzic ng-for, a map przerzuca tam wartosci
    pages = Array.from(Array((endPage + 1) - startPage).keys()).map(i => startPage + i);

    return{
      totalItems: totalItems,
      currentPage: currentPage,
      pageSize: pageSize,
      totalPages: totalPages,
      startPage: startPage,
      endPage: endPage,
      pages: pages
    };
  }

  changeSorting(sortBy: string, actualSortDir: string, actualSortBy: string) {
    if (actualSortBy !== sortBy) {
      actualSortBy = sortBy;
      actualSortDir = 'asc';
    } else {
      switch (actualSortDir) {
        case null:
          actualSortDir = 'asc';
          break;
        case 'asc':
          actualSortDir = 'desc';
          break;
        case 'desc':
          actualSortDir = '';
          actualSortBy = '';
          break;
      }
    }
    return{
      sortBy: actualSortBy,
      sortDir: actualSortDir
    };
  }
}
