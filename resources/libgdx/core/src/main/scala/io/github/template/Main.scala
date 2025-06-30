package io.github.template

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.ScreenUtils

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
class Main extends ApplicationAdapter:
  import Main.*

  private lazy val shapeRenderer = new ShapeRenderer()
  private lazy val batch = new SpriteBatch()
  private lazy val graphicsWidth = Gdx.graphics.getWidth
  private lazy val graphicsHeight = Gdx.graphics.getHeight

  override def create(): Unit =
    shapeRenderer
    batch
    graphicsWidth
    graphicsHeight

  private def drawBoard(): Unit =
    for
      row <- 0 until BOARD_SIZE
      col <- 0 until BOARD_SIZE
    do
      // Determine if the square should be black or white
      // If row + col is even, it's white; if odd, it's black
      shapeRenderer.setColor(if (row + col) % 2 == 0 then Color.WHITE else Color.BLACK)
      // Calculate isometric coordinates
      val isoX = start.x + (col - row) * TILE_WIDTH / 2f + BOARD_SIZE * TILE_WIDTH / 2f
      val isoY = start.y + (col + row) * TILE_HEIGHT / 2f
      // Draw the isometric tile (diamond shape)
      shapeRenderer.triangle(
        isoX, isoY + TILE_HEIGHT / 2f,
        isoX + TILE_WIDTH / 2f, isoY,
        isoX + TILE_WIDTH, isoY + TILE_HEIGHT / 2f
      )
      shapeRenderer.triangle(
        isoX, isoY + TILE_HEIGHT / 2f,
        isoX + TILE_WIDTH, isoY + TILE_HEIGHT / 2f,
        isoX + TILE_WIDTH / 2f, isoY + TILE_HEIGHT
      )

  private def draw(token: Token): Unit =
    // Calculate isometric coordinates for the pawn
    val pawnIsoX = start.x + (token.pos.x - token.pos.y) * TILE_WIDTH / 2f + BOARD_SIZE * TILE_WIDTH / 2f
    val pawnIsoY = start.y + (token.pos.x + token.pos.y + 1f) * TILE_HEIGHT / 2f
    // Adjust the pawn position to center it on the tile
    val pawnX = pawnIsoX + (TILE_WIDTH - SQUARE_SIZE) / 2f
    val pawnY = pawnIsoY - SQUARE_SIZE / 4f // Adjust to position pawn on the tile
    batch.draw(token.texture, pawnX, pawnY, SQUARE_SIZE, SQUARE_SIZE)

  private lazy val start: (x: Float, y: Float) =
    // Calculate the width and height of the isometric board
    val isoWidth = (BOARD_SIZE + BOARD_SIZE) * TILE_WIDTH / 2f
    val isoHeight = (BOARD_SIZE + BOARD_SIZE) * TILE_HEIGHT / 2f
    // Calculate the starting position to center the board
    val startX = (graphicsWidth - isoWidth) / 2f - isoWidth / 16f // Adjust to center horizontally
    val startY = (graphicsHeight - isoHeight) / 2f // Adjust to center vertically
    (startX, startY)

  override def render(): Unit =
    // Clear the screen
    ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f)
    // Begin shape rendering in filled mode
    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
    drawBoard()
    shapeRenderer.end()
    // Draw the pawn
    batch.begin()
    draw(Pawn(Position("B2")))
    draw(Pawn(Position("G3")))
    batch.end()

  override def dispose(): Unit =
    shapeRenderer.dispose()
    batch.dispose()

object Main:
  // Chess board properties
  private val BOARD_SIZE = 8 // 8x8 chess board
  private val SQUARE_SIZE = 80f // Size of each square in pixels
  private val TILE_WIDTH = SQUARE_SIZE // Width of an isometric tile
  private val TILE_HEIGHT = SQUARE_SIZE / 2 // Height of isometric tile (half of width for 2:1 ratio)
