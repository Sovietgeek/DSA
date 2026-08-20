class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. Length nikalo aur last node dhundo
        ListNode last = head;
        int n = 1;
        while (last.next != null) {
            last = last.next;
            n++;
        }

        // 2. Circle banao
        last.next = head;

        // 3. K ko handle karo (k length se bada ho sakta hai)
        k = k % n;
        int stepsToNewTail = n - k;

        // 4. Naye tail tak jao
        ListNode newTail = last; // purana last node reference
        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }

        // 5. Connection todo aur naya head set karo
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}