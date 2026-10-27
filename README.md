&#x20;Sorting Algorithms Benchmark (Selection Sort vs Insertion Sort)



&#x20;1. البيانات الشخصية (Personal Information)

&#x20;اسم الطالب (Student Name): \[أحمد عارف الأمير ]

&#x20;الرقم الجامعي (University ID): \[ 3166225 ]

&#x20;رقم المجموعة (Group Number): \[   C ]



\---



&#x20;2. Benchmark Results Table

Fixed dataset size for all test cases: \*\*N = 100,000\*\*



| Algorithm | Random | Reversely Sorted | Partially Sorted | Fully Sorted |

| :--- | :---: | :---: | :---: | :---: |

| \*\*Selection Sort\*\* | 3,045,994 us | 3,396,344 us | 1,508,674 us | 1,507,854 us |

| \*\*Insertion Sort\*\* | 1,539,343 us | 3,626,795 us | 733,680 us | 90 us |



\---



&#x20;3. التحليل ومناقشة النتائج (Analysis and Discussion)



\- أ. مقارنة الأداء بين خوارزميات $O(N^2)$ وخوارزميات $O(N \\log N)$ (Performance Comparison):

&#x20;   خوارزميات الترتيب التربيعية مثل Selection Sort و Insertion Sort تستهلك وقتاً طويلاً نسبياً وتتأثر بزيادة حجم البيانات ($N = 100,000$)، مما يرفع وقت التنفيذ لعدة ثوانٍ.

* &#x20;على النقيض من ذلك، فإن الخوارزميات ذات التعقيد اللوغاريتمى $O(N \\log N)$ مثل Quick Sort و Merge Sort تعمل بكفاءة وقدرة أعلى بكثير للبيانات الضخمة.



\- ب. الخوارزمية الأفضل في البيانات المرتبة والمرتبة جزئياً مع التعليل (Best Algorithm Justification):

\* \*\*الخوارزمية الأفضل:\*\* \*\*Insertion Sort\*\*.

\* \*\*التعليل:\*\* 

&#x20; \* في \*\*الحالة المرتبة تماماً (Fully Sorted)\*\*، تصل تعقيدية Insertion Sort إلى $O(N)$\[cite: 2] لأن حلقة التكرار الداخلية لا تتنفذ، مما أدى لإنهاء التنفيذ في \*\*90 us فقط\*\*.

&#x20; \* في \*\*الحالة المرتبة جزئياً (Partially Sorted)\*\*، تكون سريعة لأنها تتطلب إزاحات محدودة للعناصر، بينما تستمر Selection Sort في فحص جميع العناصر دائماً محتفظة بتعقيد $O(N^2)\[cite: 2]$.



\### ج. سلوك خوارزمية Quick Sort وتأثير عنصر المحور Pivot (Quick Sort Behavior):

\* عند اختيار العنصر الأول أو الأخير كمحور (Pivot) في مصفوفة مرتبة كلياً أو عكسياً، ينقسم القسم بشكل غير متوازن تماماً.

\* هذا يسبب أسوأ حالة تشغيل (Worst-case) والتي تهبط بالأداء من $O(N \\log N)$ إلى $O(N^2)$. ويتم معالجة ذلك عبر اختيار محور عشوائي (Random Pivot).

