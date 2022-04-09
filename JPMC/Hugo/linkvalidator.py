from pylinkvalidator.api import crawl_with_options

crawled_site = crawl_with_options(["http://localhost:1313/docs/faq/"], {"run-once" : True, "types" : "a", "progress" : True, "report-type" : "all", "strict" : True, "accepted-hosts" : "www.youtube.com"})
number_of_crawled_pages = len(crawled_site.pages)
number_of_errors = len(crawled_site.error_pages)
