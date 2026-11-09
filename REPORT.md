# Campus Card Lab — Report

**Student Name:** Ravil Musaev  
**Student ID:** 2026001  
**Project:** CampusCardLab  
**Technology:** Kotlin and Jetpack Compose

## Exercise 1 — Horizontal Alignment

The title block (Campus Card, student name and ID) is centered horizontally, while the schedule rows remain left-aligned.

## Exercise 2 — SpaceBetween vs Center

I tested two horizontal arrangements:

- SpaceBetween — buttons are positioned at opposite sides of the screen.
- Center with spacedBy(16.dp) — buttons are grouped in the center with 16 dp spacing.

I chose SpaceBetween for the final layout because it separates the Map and Show QR buttons and makes the interface easier to use.

## Exercise 3 — Vertical Alignment

Top alignment places the time at the top of the schedule row, while CenterVertically aligns it with the vertical center of the course text.

CenterVertically provides a more balanced appearance when the course title occupies multiple lines.

## Exercise 5 — Nested Layout Refactor

I extracted two reusable composable functions:

\\\kotlin
@Composable
fun ProfileHeader(name: String, status: String)

@Composable
fun ScheduleRow(
    time: String,
    title: String,
    room: String,
    alignTop: Boolean = false
)
\\\

These functions make the code more organized and reusable.

## Exercise 6 — Vertical Arrangement

Arrangement.SpaceBetween distributes the available vertical space between the main content and the bottom action bar. The profile and schedule stay in the upper section, while the action buttons move closer to the bottom of the screen. This layout is useful because it separates student information from the actions.

## Conclusion

In this laboratory work, I learned how to build Android interfaces using Jetpack Compose. I practiced Column, Row, Alignment, Arrangement and Modifier.weight(). I also learned how to extract reusable composable functions and organize the application interface.